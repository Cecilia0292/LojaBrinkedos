# 🏪 BrinkeBrink - Sistema de Cadastro de Brinquedos  

## 📌 Sobre o projeto  
O **BrinkeBrink** é um sistema de cadastro de brinquedos desenvolvido em **Java**, que permite gerenciar **duas listas**: uma para os nomes dos brinquedos e outra para seus preços.  

O sistema oferece diversas funcionalidades, incluindo:  
✅ Cadastro de brinquedos  
✅ Listagem de todos os brinquedos  
✅ Remoção de brinquedos pelo nome  
✅ Consulta ao brinquedo mais caro  
✅ Cálculo da média de preços  
✅ Exibição de brinquedos acima da média  
✅ Atualização do preço de um brinquedo  
✅ Exibição do total em dinheiro dos brinquedos cadastrados  

## 🎮 Como funciona?  
O usuário interage com o sistema por meio de um **menu**, onde pode escolher as opções desejadas. O programa utiliza **listas sincronizadas** para armazenar os nomes e preços dos brinquedos, garantindo que os dados estejam sempre organizados corretamente.  

Além disso, foram implementadas verificações para evitar erros, como:  
- **Nomes duplicados** (não permite cadastrar brinquedos com o mesmo nome).  
- **Preços inválidos** (não permite valores negativos).  
- **Remoção segura** (garante que nome e preço sejam removidos juntos).  

Com essa estrutura, o **BrinkeBrink** proporciona uma maneira eficiente e intuitiva de gerenciar brinquedos em uma loja, facilitando consultas e análises de preços.  

## 🛠️ Tecnologias utilizadas  
- **Java** (linguagem de programação)  
- **Scanner** (entrada de dados do usuário)  
- **ArrayList** (armazenamento dinâmico de brinquedos e preços)  

## 🚀 Como executar o projeto  
1. **Clone o repositório**  
   ```bash
   git clone https://github.com/seu-usuario/brinkebrink.git
- Compile e execute o programa
javac Main.java
java Main
- Interaja com o menu e gerencie seus brinquedos!
