# AC3 - Paradigmas de Programação (Ciência da Computação)
# Objetivos: Implementação de classes, herança, e polimorfismo em Python.
#
# A seguir, informe o e-mail institucional dos membros do grupo:
# Email Impacta: alex.carvalho@aluno.faculdadeimpacta.com.br
# Email Impacta: antonio.gally@aluno.faculdadeimpacta.com.br
# Email Impacta: iris.trujillo@aluno.faculdadeimpacta.com.br


"""
Dicas importantes:
	-Alguns itens pedem para que você teste se alguma variável é instância de
	uma classe ou se é de algum tipo de dado. Para isso, utilize as seguintes
	funções:
	isinstance(obj, NomeDaClasse) e type(obj), onde "obj" é uma variável/objeto.

	EXEMPLO: suponha a variável "prod" que é uma instância da classe Produto.
	Ao chamar isinstance(prod, Produto), estamos verificando se a variável "prod"
	é uma instância da classe produto, o que retorna True.
	Da mesma forma, podemos utilizar a expressão type(prod) == Produto, que retornará
	True neste caso.

	OBS: a função isinstance(objeto, Classe) possui um comportamento diferente da
	expressão type(objeto) == Classe quando consideramos o contexto de Herança.
	Imagine agora que a variável "prod_fisico" é uma instância da classe ProdutoFisico
	(que deve herdar de Produto).
	Agora, tanto isinstance(prod_fisico, ProdutoFisico) como também isinstance(prod_fisico, Produto)
	retornarão True em ambos os casos, pois a classe ProdutoFisico herda de Produto.
	Já a expressão type(prod_fisico) == ProdutoFisico resulta em True, enquanto que
	type(prod_fisico) == Produto resulta em False!
	
	Essa diferença será importante para resolver alguns itens da atividade!
"""


class Produto:
    def __init__(self, nome, preco):
        self.nome = nome
        self.preco = preco

    @property
    def nome(self):
        return self.__nome
    
    @property
    def preco(self):
        return self.__preco

    @nome.setter
    def nome(self, novo_nome):
        if isinstance(novo_nome, str) and novo_nome != '':
            self.__nome = novo_nome
        else:
            self.__nome = "-"

    @preco.setter
    def preco(self, novo_preco):
        if (isinstance(novo_preco, (int, float)) and novo_preco > 0):
            self.__preco = novo_preco
        else:
            self.__preco = 0

    def calcular_preco_com_frete(self):
        return self.__preco
    
    pass

class ProdutoFisico(Produto):
    def __init__(self, nome, preco, peso):
        super().__init__(nome, preco)
        self.peso = peso

    @property
    def peso(self):
        return self.__peso

    @peso.setter
    def peso(self, novo_peso):
        if isinstance(novo_peso, int) and novo_peso >= 100:
            self.__peso = novo_peso
        else:
            self.__peso = 100

    def peso_em_kg(self):
        return self.__peso / 1000

    def calcular_preco_com_frete(self):

        peso_kg = self.peso_em_kg()
        valor_frete = peso_kg * 5
        preco_final = self.preco + valor_frete 
        return preco_final
    
    pass

class ProdutoEletronico(ProdutoFisico):
    def __init__(self, nome, preco, peso, tensao, tempo_garantia):
        super().__init__(nome, preco, peso)
        self.tensao = tensao
        self.tempo_garantia = tempo_garantia

    @property
    def tensao(self):
        return self.__tensao

    @tensao.setter
    def tensao(self, nova_tensao):
        if isinstance(nova_tensao, int) and nova_tensao in (0, 127, 220):
            self.__tensao = nova_tensao
        else:
            self.__tensao = 0

    @property
    def tempo_garantia(self):
        return self.__tempo_garantia

    @tempo_garantia.setter
    def tempo_garantia(self, novo_tempo_garantia):
        if isinstance(novo_tempo_garantia, int) and novo_tempo_garantia > 0:
            self.__tempo_garantia = novo_tempo_garantia
        else:
            self.__tempo_garantia = 12

    def calcular_preco_com_frete(self):
        preco_com_frete_produto_fisico = super().calcular_preco_com_frete()
        taxa_adicional = preco_com_frete_produto_fisico * 0.01
        preco_final = preco_com_frete_produto_fisico + taxa_adicional
        return preco_final

    pass

class Carrinho:
    def __init__(self):
        self.__itens = []

    def adicionar(self, item):
        if isinstance(item, (ProdutoFisico, ProdutoEletronico)):
            self.__itens.append(item)

    def qtd_produtos_fisicos(self):
        return sum(1 for item in self.__itens if type(item) is ProdutoFisico)

    def qtd_produtos_eletronicos(self):
        return sum(1 for item in self.__itens if isinstance(item, ProdutoEletronico))

    def total_sem_frete(self):
        return sum(item.preco for item in self.__itens)

    def total_com_frete(self, desconto):
        total = sum(item.calcular_preco_com_frete() for item in self.__itens)
        desconto_valor = (desconto / 100) * total
        return total - desconto_valor

    pass

if __name__ == '__main__':   # não apague ou modifique essa linha
    pass
    """
    Caso deseje testar as classes implementadas, escreva o seu código INDENTADO
    dentro deste if. Ele só será executado caso você rode o arquivo ac3.py diretamente.

    Quando o arquivo for chamado como módulo (que é o caso quando você executa o
    arquivo test_ac3.py), o código abaixo será ignorado.
    """
