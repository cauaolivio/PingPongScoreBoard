# PingPongScoreBoard

Placar de partida entre dois jogadores (Jogador A e Jogador B), desenvolvido como exercício sobre ciclo de vida de `Activity` e gerenciamento de estado em Jetpack Compose.

O objetivo é implementar a mesma aplicação em 4 etapas, usando uma abordagem diferente de estado em cada uma, e comparar o comportamento de cada uma frente a:
- Rotação de tela
- Morte do processo pelo sistema

## Comparativo das abordagens

| Abordagem | Rotação de tela | Morte do processo |
|---|---|---|
| `remember` | Não sobrevive | Não sobrevive |
| `ViewModel` + `mutableStateOf` | | |
| `ViewModel` + `StateFlow` | | |
| `ViewModel` + `SavedStateHandle` | | |