[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-f4981d0f882b2a3f0472912d15f9806d57e124e0fc890972558857b51b24a6f9.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10100411)
# Trabalho: Gestão de estoque
(Feito por João)
Um sistema simples de controle de estoque para aplicar conceitos básicos de OO. Um produto deve calcular seu preço de venda e o estoque deve calcular quantidades e pedidos de compra e venda.

---

## Nota base do grupo: 11

A nota final, que é individual, se dará pela nota acima, multiplicada por um peso entre 0 e 1 relativo ao acompanhamento semanal do projeto. Lembre-se: não é só a entrega do produto finalizado que importa, é todo o processo de sua construção e as entregas parciais para o “cliente”.

## Comentários
- Sem descontar pontos (ainda)
    - atenção para a consistência nos elementos: vocês têm métodos começando com minúsculas, com maiúsculas...
    - se vão usar exceções, usem direito. "Exception" para tudo é muito inadequado 

### Diagrama + aderência das classes ao diagrama: 2/2 pontos 
Sem descontar ponto: a relação é de associação ou pertencimento? Faz sentido existirem objetos Produto fora do Estoque?
### Requisitos corretamente implementados: 3,5/6 pontos 
	- produto (preço, estoque)
        - dois métodos públicos para preco de venda?
        - cálculos internos recebendo atributos como parâmetro?
	- estoque (valor, abaixo do estoque)
        - no main: estoque deve encapsular ação de produto.
	- sistema (vender, comprar, consultas)
        - vendi e comprei quantidades negativas...

### Documentação de código: 3/3 pontos 
	
	
### Testes (quantidade e qualidade): 2,5/4 pontos 
Tem meu copyright nos testes, mas não fui eu quem fiz os testes!! Me incluam fora dessa!! 😂
Se usaram exceções, precisariam ter usado os testes corretos de exceção. (asserThrows)
    - produto: 1,5/2 pontos (vendas e compras negativas)
	- estoque: 1/2 pontos (testes de exceções, repetição de comandos)
	
---

## Alunos integrantes da equipe

* Bruno Pontes Duarte
* Diogo Martins de Assis
* Eduardo Augusto Brito
* Marcos Paulo Freitas da Silva
* Samuel Marques Sousa Leal

## Professores responsáveis

* João Caram Santos de Oliveira
