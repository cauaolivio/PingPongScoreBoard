# PingPongScoreBoard

Placar de partida entre dois jogadores (Jogador A e Jogador B), desenvolvido como exercício sobre ciclo de vida de `Activity` e gerenciamento de estado em Jetpack Compose.

O objetivo é implementar a mesma aplicação em 4 etapas, usando uma abordagem diferente de estado em cada uma, e comparar o comportamento de cada uma frente a:
- Rotação de tela
- Morte do processo pelo sistema

## Comparativo das abordagens

| Abordagem | Rotação de tela | Morte do processo |
|---|---|---|
| `remember` | Não sobrevive | Não sobrevive |
| `ViewModel` + `mutableStateOf` | Sobrevive | Não sobrevive |
| `ViewModel` + `StateFlow` | Sobrevive | Não sobrevive |
| `ViewModel` + `SavedStateHandle` | | |

## Perguntas

**1. Por que o ViewModel sozinho (etapas 2 e 3) não é suficiente para sobreviver à morte do processo, mesmo sobrevivendo à rotação de tela?**

Na rotação, só a `Activity` é destruída e recriada — o processo continua vivo, e o `ViewModel` junto com ele. Na morte do processo, o processo inteiro é encerrado, liberando toda a memória, inclusive o `ViewModel`. Ao reabrir, uma nova instância é criada do zero.

**2. Qual a diferença prática entre usar mutableStateOf e StateFlow dentro do ViewModel nesta aplicação? Em algum momento essa diferença foi perceptível nos testes?**

Nos testes de ciclo de vida, nenhuma — ambos sobrevivem à rotação e não sobrevivem à morte do processo, pois vivem dentro do mesmo `ViewModel`. A diferença é de API: `mutableStateOf` é do Compose e é lido direto; `StateFlow` é do Kotlin Coroutines e precisa de `collectAsState()` para virar estado do Compose.

**3. Se este placar precisasse ser salvo permanentemente (mesmo após o usuário fechar o app e abrir dias depois), qual das quatro abordagens ainda seria insuficiente, e o que seria necessário adicionar?**

Todas seriam insuficientes. O `SavedStateHandle` sobrevive enquanto o app ainda está "vivo" no sistema, mas não é persistência permanente. Seria necessário salvar os dados em `DataStore`, `SharedPreferences` ou `Room`.

**4. Na sua opinião, qual abordagem você usaria em produção para este placar e por quê?**

`ViewModel` + `StateFlow` — cobre a rotação de tela, se integra bem com Coroutines caso o app cresça, e é mais testável que o `mutableStateOf`.