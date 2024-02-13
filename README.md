# listagem de filmes populares com MVVM e retrofit
Aplicativo android que lista e exibe os detalhes de filmes populares, utlilizando retrofit e padrão de arquitetura MVVM

## Funcionamento
O aplicativo faz uma requisição via Retrofit para a API, a fim de receber os filmes, que são divididos em páginas na API. Em seguida, ele faz uma listagem de cards com RecyclerView utilizando os dados obtidos. Ao clicar em um card, o usuário é redirecionado para uma nova página que exibe os detalhes do filme. Quando o RecyclerView chega ao fim, o aplicativo faz uma nova requisição para a próxima página na API e exibe uma barra de progresso enquanto a requisição é feita. Quando a requisição é finalizada, os novos dados obtidos são adicionados ao RecyclerView.

## Tecnologias e bibliotecas utilizadas
- retrofit
- okhttp3
- recycleview
- Glide
- gson

## Features
- paginação
- tratamento de erro
- listagem
- Exibição de detalhes ao clicar no card

## Arquitetura
Foi utilizado padrão de arquitetura MVVM com LiveData e repository

## Api utilizada
O aplicativo utiliza a api do The Movie Database

## Screenshots
<img src="https://github.com/JoaoViniciusLima/listagem-de-filmes-populares-com-MVVM-e-retrofit/assets/87715417/ebd1220b-2d36-46b4-bbb7-296a280b135c" alt="detalhes" width="350"/>
<img src="https://github.com/JoaoViniciusLima/listagem-de-filmes-populares-com-MVVM-e-retrofit/assets/87715417/c9520a1a-2c43-4268-831a-729aea22371f" alt="listagem" width="350"/>


https://github.com/JoaoViniciusLima/listagem-de-filmes-populares-com-MVVM-e-retrofit/assets/87715417/6c8cb50d-35df-4b2d-9fd7-f84cc2703f71



