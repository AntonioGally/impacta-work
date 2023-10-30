import pytest
import ac3

"""
NÃO entregue nem modifique esse arquivo.
Ele serve somente para que você teste a sua atividade.
"""

@pytest.mark.parametrize('atributo', ['_Produto__nome', '_Produto__preco'])
def test_cria_produto(atributo):
	try:
		prod = ac3.Produto('Jogo online', 99)
	except Exception:
		raise AssertionError('Erro no construtor da classe Produto')
	else:
		mensagens_atributos = {'_Produto__nome': 'Classe Produto: não criou o atributo privado nome',
		'_Produto__preco':'Classe Produto: não criou o atributo privado preco'}
		assert hasattr(prod, atributo), mensagens_atributos[atributo]


@pytest.mark.parametrize('nome', ['Jogo', 'Microsoft Office'])
def test_produto_atributo_nome(nome):
	try:
		prod = ac3.Produto(nome, 100)
		assert prod._Produto__nome == nome
	except Exception:
		raise AssertionError('Erro ao inicializar o atributo privado nome na classe Produto')


@pytest.mark.parametrize('nome', ['Jogo', 'Microsoft Office'])
def test_produto_property_nome(nome):
	try:
		prod = ac3.Produto(nome, 100)
		assert prod.nome == nome
	except Exception:
		raise AssertionError('Erro no valor da property nome na classe Produto')


@pytest.mark.parametrize('preco', [100, 100.5])
def test_produto_preco_valido(preco):
	try:
		tipo = 'int' if isinstance(preco, int) else 'float' if isinstance(preco, float) else ''
		prod = ac3.Produto('Jogo online', preco)
	except Exception:
		raise AssertionError('Erro ao criar Produto com preço do tipo {0}'.format(tipo))


def test_produto_setter_nome_vazio():
	try:
		prod = ac3.Produto('Teste', 30)
		prod.nome = ''
		assert prod.nome == '-'
	except Exception:
		raise AssertionError('Erro ao atribuir uma string vazia ao setter nome')


def test_produto_setter_nome_tipo_diferente():
	try:
		prod = ac3.Produto('Teste', 30)
		prod.nome = []
		assert prod.nome == '-'
	except Exception:
		raise AssertionError('Erro ao atribuir um valor não string ao setter nome')


@pytest.mark.parametrize('preco', ["", []])
def test_produto_setter_preco_invalido(preco):
	try:
		prod = ac3.Produto('Jogo online', preco)
		prod.preco = preco
		assert prod.preco == 0
	except Exception:
		raise AssertionError('Erro ao atribuir um preço com tipo inválido ao setter preco')


@pytest.mark.parametrize('preco', [-1, -3.0])
def test_cria_produto_preco_negativo(preco):
	try:
		prod = ac3.Produto('Jogo online', preco)
		prod.preco = preco
		assert prod.preco == 0
	except Exception:
		raise AssertionError('Erro ao atribuir um preço com valor negativo ao setter preco')


@pytest.mark.parametrize('preco', [1, 30])
def test_produto_metodo_calcular_preco_com_frete(preco):
	try:
		prod = ac3.Produto('Jogo online', preco)
		assert prod.calcular_preco_com_frete() == preco
	except Exception:
		raise AssertionError('O método calcular_preco_com_frete() deve retornar o preço do Produto')


@pytest.mark.parametrize('atributo', ['_ProdutoFisico__peso'])
def test_cria_produtoFisico(atributo):
	try:
		prod = ac3.ProdutoFisico('Cadeira', 99, 1000)
	except Exception:
		raise AssertionError('Erro no construtor da classe ProdutoFisico')
	else:
		mensagens_atributos = {'_ProdutoFisico__peso': 'Classe ProdutoFisico: não criou o atributo privado peso'}
		assert hasattr(prod, atributo), mensagens_atributos[atributo]


def test_produtoFisico_heranca():
	try:
		prod = ac3.ProdutoFisico('Cadeira', 99, 1000)
	except Exception:
		raise AssertionError('Erro no construtor da classe ProdutoFisico')
	assert isinstance(prod, ac3.Produto) and isinstance(prod, ac3.ProdutoFisico), 'A classe ProdutoFisico deve herdar da classe Produto'


def test_produtoFisico_caracteristicas_herdadas():
	try:
		nome, preco = 'Cadeira', 99
		prod = ac3.ProdutoFisico(nome, preco, 1000)
		dict_attrs_classe = vars(ac3.ProdutoFisico)
		dict_attrs_obj = vars(prod)
	except Exception:
		raise AssertionError('Erro no construtor da classe ProdutoFisico')
	assert ('_Produto__nome' in dict_attrs_obj) and ('_Produto__preco' in dict_attrs_obj) and ('_ProdutoFisico__nome' not in dict_attrs_obj) and ('_ProdutoFisico__preco' not in dict_attrs_obj), 'A classe ProdutoFisico não deve possuir os atributos privados nome e preco'
	assert ('nome' not in dict_attrs_classe) and ('preco' not in dict_attrs_classe), 'A classe ProdutoFisico deve herdar as properties da classe Produto'
	assert prod.nome == nome and prod.preco == preco, 'As properties herdadas pela classe ProdutoFisico não possuem valores válidos'

@pytest.mark.parametrize('nome,preco,peso', [('Copo',5,100)])
def test_produtoFisico_inicializado_corretamente(nome, preco, peso):
	try:
		prod = ac3.ProdutoFisico(nome, preco, peso)
	except Exception:
		raise AssertionError('Erro no construtor da classe ProdutoFisico')
	assert hasattr(prod, "_Produto__nome"), "A classe Produto não possui o atributo privado nome"
	assert hasattr(prod, "_Produto__preco"), "A classe Produto não possui o atributo privado preco"
	assert hasattr(prod, "_ProdutoFisico__peso"), "A classe ProdutoFisico não possui o atributo privado peso"
	assert prod._Produto__nome == nome and prod._Produto__preco == preco and prod._ProdutoFisico__peso == peso, 'A classe ProdutoFisico deve inicializar seus atributos e os atributos da super classe corretamente'

@pytest.mark.parametrize('peso', [100, 3500])
def test_produtoFisico_property_peso(peso):
	try:
		prod = ac3.ProdutoFisico('Cadeira', 99, peso)
		assert prod.peso == peso
	except Exception:
		raise AssertionError('O valor da property peso na classe ProdutoFisico é diferente do valor utilizado no construtor')


@pytest.mark.parametrize('peso', ["", []])
def test_cria_produtoFisico_peso_invalido(peso):
	try:
		prod = ac3.ProdutoFisico('Cadeira', 99, peso)
		assert prod.peso == 100
	except Exception:
		raise AssertionError('O peso do ProdutoFisico deve ser igual a 100 quando seu valor não é do tipo int')


@pytest.mark.parametrize('peso', [99, -1000])
def test_cria_produtoFisico_peso_abaixo_100(peso):
	try:
		prod = ac3.ProdutoFisico('Cadeira', 99, peso)
		assert prod.peso == 100
	except Exception:
		raise AssertionError('O peso do ProdutoFisico deve ser igual a 100 quando seu valor for menor que 100')


@pytest.mark.parametrize('peso', ["", []])
def test_produtoFisico_setter_peso_invalido(peso):
	try:
		prod = ac3.ProdutoFisico('Cadeira', 99, 5000)
		prod.peso = peso
		assert prod.peso == 100
	except Exception:
		raise AssertionError('O peso do ProdutoFisico deve ser igual a 100 quando seu valor não é do tipo int')


@pytest.mark.parametrize('peso', [99, -100])
def test_produtoFisico_setter_peso_abaixo_100(peso):
	try:
		prod = ac3.ProdutoFisico('Cadeira', 99, 5000)
		prod.peso = peso
		assert prod.peso == 100
	except Exception:
		raise AssertionError('O peso do ProdutoFisico deve ser igual a 100 quando seu valor for menor que 100')


@pytest.mark.parametrize('peso,peso_kg', [(1000,1.0), (9500,9.5)])
def test_produtoFisico_metodo_peso_em_kg(peso, peso_kg):
	try:
		prod = ac3.ProdutoFisico('Cadeira', 99, peso)
	except Exception:
		raise AssertionError('Erro ao instanciar um ProdutoFisico')
	assert prod.peso_em_kg() == peso_kg, "O método peso_em_kg() não calculou o peso em kg do ProdutoFisico corretamente"


@pytest.mark.parametrize('preco,peso,total', [(100,5000,125), (300,9500,347.5)])
def test_produtoFisico_metodo_calcular_preco_com_frete(preco, peso, total):
	try:
		prod = ac3.ProdutoFisico('Cadeira', preco, peso)
	except Exception:
		raise AssertionError('Erro ao instanciar um ProdutoFisico')
	assert prod.calcular_preco_com_frete() == total, "O método calcular_preco_com_frete() não calculou o preço com frete do ProdutoFisico corretamente"
	assert prod.preco == preco, "O valor do atributo privado preco não deve ser alterado ao chamar calcular_preco_com_frete()"


@pytest.mark.parametrize('atributo', ['_ProdutoEletronico__tensao', '_ProdutoEletronico__tempo_garantia'])
def test_cria_produtoEletronico(atributo):
	try:
		prod = ac3.ProdutoEletronico('Geladeira', 5000, 35000, 127, 12)
	except Exception:
		raise AssertionError('Erro no construtor da classe ProdutoEletronico')
	else:
		mensagens_atributos = {'_ProdutoEletronico__tensao': 'Classe ProdutoEletronico: não criou o atributo privado tensao',
		'_ProdutoEletronico__tempo_garantia': 'Classe ProdutoEletronico: não criou o atributo privado tempo_garantia'}
		assert hasattr(prod, atributo), mensagens_atributos[atributo]


def test_produtoEletronico_heranca():
	try:
		prod = ac3.ProdutoEletronico('Geladeira', 5000, 35000, 127, 12)
	except Exception:
		raise AssertionError('Erro no construtor da classe ProdutoEletronico')
	assert isinstance(prod, ac3.ProdutoFisico) and isinstance(prod, ac3.ProdutoEletronico), 'A classe ProdutoEletronico deve herdar da classe ProdutoFisico'


def test_produtoEletronico_caracteristicas_herdadas():
	try:
		nome, preco, peso = 'Geladeira', 4500, 29000
		prod = ac3.ProdutoEletronico(nome, preco, peso, 127, 12)
		dict_attrs_classe = vars(ac3.ProdutoEletronico)
		dict_attrs_obj = vars(prod)
	except Exception:
		raise AssertionError('Erro no construtor da classe ProdutoEletronico')
	assert ('_Produto__nome' in dict_attrs_obj) and ('_Produto__preco' in dict_attrs_obj) and ('_ProdutoFisico__peso' in dict_attrs_obj) and ('_ProdutoEletronico__nome' not in dict_attrs_obj) and ('_ProdutoEletronico__preco' not in dict_attrs_obj) and ('_ProdutoEletronico__peso' not in dict_attrs_obj), 'A classe ProdutoEletronico não deve possuir os atributos privados nome, preco e peso'
	assert ('nome' not in dict_attrs_classe) and ('preco' not in dict_attrs_classe) and ('peso' not in dict_attrs_classe), 'A classe ProdutoEletronico deve herdar as properties da classe ProdutoFisico'
	assert prod.nome == nome and prod.preco == preco and prod.peso == peso, 'As properties herdadas pela classe ProdutoEletronico não possuem valores válidos'


@pytest.mark.parametrize('nome,preco,peso,tensao,tempo_garantia', [('Cafeteira',300,1500,127,6), ('Geladeira',3500,25000,220,12), ('Televisao',4000,8500,0,24)])
def test_cria_produtoEletronico_inicializado_corretamente(nome, preco, peso, tensao, tempo_garantia):
	try:
		prod = ac3.ProdutoEletronico(nome, preco, peso, tensao, tempo_garantia)
	except Exception:
		raise AssertionError('Erro no construtor da classe ProdutoEletronico')
	assert hasattr(prod, "_Produto__nome"), "A classe Produto não possui o atributo privado nome"
	assert hasattr(prod, "_Produto__preco"), "A classe Produto não possui o atributo privado preco"
	assert hasattr(prod, "_ProdutoFisico__peso"), "A classe ProdutoFisico não possui o atributo privado peso"
	assert hasattr(prod, "_ProdutoEletronico__tensao"), "A classe ProdutoEletronico não possui o atributo privado tensao"
	assert hasattr(prod, "_ProdutoEletronico__tempo_garantia"), "A classe ProdutoEletronico não possui o atributo privado tempo_garantia"
	assert prod._Produto__nome == nome and prod._Produto__preco == preco and prod._ProdutoFisico__peso == peso and prod._ProdutoEletronico__tensao == tensao and prod._ProdutoEletronico__tempo_garantia == tempo_garantia, 'A classe ProdutoEletronico deve inicializar seus atributos e os atributos da super classe corretamente'


@pytest.mark.parametrize('tensao', [0, 127, 220])
def test_produtoEletronico_property_tensao(tensao):
	try:
		prod = ac3.ProdutoEletronico('Aspirador', 400, 5000, tensao, 24)
		assert prod.tensao == tensao
	except Exception:
		raise AssertionError('O valor da property tensao na classe ProdutoEletronico é diferente do valor utilizado no construtor')


@pytest.mark.parametrize('tensao', ["", []])
def test_cria_produtoEletronico_tensao_tipo_invalido(tensao):
	try:
		prod = ac3.ProdutoEletronico('Aspirador', 400, 5000, tensao, 24)
		assert prod.tensao == 0
	except Exception:
		raise AssertionError('A tensao do ProdutoEletronico deve ser igual a 0 quando seu valor não é do tipo int')


@pytest.mark.parametrize('tensao', [-50, 110, 240])
def test_cria_produtoEletronico_tensao_valor_invalido(tensao):
	try:
		prod = ac3.ProdutoEletronico('Aspirador', 400, 5000, tensao, 24)
		assert prod.tensao == 0
	except Exception:
		raise AssertionError('A tensao do ProdutoEletronico deve ser igual a 0 quando seu valor for diferente de 127 ou 220')


@pytest.mark.parametrize('tensao', ["", []])
def test_produtoEletronico_setter_tensao_tipo_invalido(tensao):
	try:
		prod = ac3.ProdutoEletronico('Aspirador', 400, 5000, tensao, 24)
		prod.tensao = tensao
		assert prod.tensao == 0
	except Exception:
		raise AssertionError('A tensao do ProdutoEletronico deve ser igual a 0 quando seu valor não é do tipo int')


@pytest.mark.parametrize('tensao', [-50, 110, 240])
def test_produtoEletronico_setter_tensao_valor_invalido(tensao):
	try:
		prod = ac3.ProdutoEletronico('Aspirador', 400, 5000, tensao, 24)
		prod.tensao = tensao
		assert prod.tensao == 0
	except Exception:
		raise AssertionError('A tensao do ProdutoEletronico deve ser igual a 0 quando seu valor for diferente de 127 ou 220')


@pytest.mark.parametrize('tempo_garantia', [6, 18])
def test_produtoEletronico_property_tempo_garantia(tempo_garantia):
	try:
		prod = ac3.ProdutoEletronico('Aspirador', 400, 5000, 0, tempo_garantia)
		assert prod.tempo_garantia == tempo_garantia
	except Exception:
		raise AssertionError('O valor da property tempo_garantia na classe ProdutoEletronico é diferente do valor utilizado no construtor')


@pytest.mark.parametrize('tempo_garantia', ["", []])
def test_cria_produtoEletronico_tempo_garantia_invalido(tempo_garantia):
	try:
		prod = ac3.ProdutoEletronico('Aspirador', 400, 5000, 0, tempo_garantia)
		assert prod.tempo_garantia == 12
	except Exception:
		raise AssertionError('O tempo_garantia do ProdutoEletronico deve ser igual a 12 quando seu valor não é do tipo int')


@pytest.mark.parametrize('tempo_garantia', [-2, 0])
def test_cria_produtoEletronico_tempo_garantia_abaixo_1(tempo_garantia):
	try:
		prod = ac3.ProdutoEletronico('Aspirador', 400, 5000, 0, tempo_garantia)
		assert prod.tempo_garantia == 12
	except Exception:
		raise AssertionError('O tempo_garantia do ProdutoEletronico deve ser igual a 12 quando seu valor for menor ou igual a 0')


@pytest.mark.parametrize('tempo_garantia', ["", []])
def test_produtoEletronico_setter_tempo_garantia_invalido(tempo_garantia):
	try:
		prod = ac3.ProdutoEletronico('Aspirador', 400, 5000, 0, tempo_garantia)
		prod.tempo_garantia = tempo_garantia
		assert prod.tempo_garantia == 12
	except Exception:
		raise AssertionError('O tempo_garantia do ProdutoEletronico deve ser igual a 12 quando seu valor não é do tipo int')


@pytest.mark.parametrize('tempo_garantia', [-5, 0])
def test_produtoEletronico_setter_tempo_garantia_abaixo_1(tempo_garantia):
	try:
		prod = ac3.ProdutoEletronico('Aspirador', 400, 5000, 0, tempo_garantia)
		prod.tempo_garantia = tempo_garantia
		assert prod.tempo_garantia == 12
	except Exception:
		raise AssertionError('O tempo_garantia do ProdutoEletronico deve ser igual a 12 quando seu valor for menor ou igual a 0')


@pytest.mark.parametrize('preco,peso,total', [(100,5000,126.25), (300,9000,348.45), (500, 200, 506.01)])
def test_produtoEletronico_metodo_calcular_preco_com_frete(preco, peso, total):
	try:
		prod = ac3.ProdutoEletronico('Geladeira', preco, peso, 0, 12)
	except Exception:
		raise AssertionError('Erro ao instanciar um ProdutoEletronico')
	assert prod.calcular_preco_com_frete() == total, "O método calcular_preco_com_frete() não calculou o preço com frete do ProdutoEletronico corretamente"
	assert prod.preco == preco, "O valor do atributo privado preco não deve ser alterado ao chamar calcular_preco_com_frete()"


@pytest.mark.parametrize('atributo', ['_Carrinho__itens'])
def test_cria_carrinho(atributo):
	try:
		carrinho = ac3.Carrinho()
	except Exception:
		raise AssertionError('Erro no construtor da classe Carrinho')
	else:
		mensagens_atributos = {'_Carrinho__itens': 'Classe Carrinho: não criou o atributo privado itens'}
		assert hasattr(carrinho, atributo), mensagens_atributos[atributo]


@pytest.mark.parametrize('situacao', [1, 2])
def test_carrinho_adicionar(situacao):
	try:
		carrinho = ac3.Carrinho()
	except Exception:
		raise AssertionError('Erro no construtor da classe Carrinho')
	try:
		prods = []
		prods.append(ac3.ProdutoFisico('Cadeira', 100, 5000))
		prods.append(ac3.ProdutoEletronico('Geladeira', 4000, 42000, 0, 12))
		prods.append(ac3.ProdutoFisico('Mesa', 1000, 15000))
		if situacao == 2:
			prods.append(ac3.ProdutoFisico('Copo', 10, 200))
			prods.append(ac3.ProdutoEletronico('Cafeteira', 250, 1500, 0, 24))
	except:
		raise AssertionError('Erro ao instanciar os produtos')
	try:
		for prod in prods:
			carrinho.adicionar(prod)
	except:
		raise AssertionError('Erro ao adicionar produtos no carrinho')
	if situacao == 1:
		assert len(carrinho._Carrinho__itens) == 3 and (carrinho._Carrinho__itens[0].nome == 'Cadeira') and (carrinho._Carrinho__itens[1].nome == 'Geladeira') and (carrinho._Carrinho__itens[2].nome == 'Mesa'), 'A lista de itens do carrinho não corresponde aos itens adicionados'
	elif situacao == 2:
		assert len(carrinho._Carrinho__itens) == 5 and (carrinho._Carrinho__itens[0].nome == 'Cadeira') and (carrinho._Carrinho__itens[1].nome == 'Geladeira') and (carrinho._Carrinho__itens[2].nome == 'Mesa') and (carrinho._Carrinho__itens[3].nome == 'Copo') and (carrinho._Carrinho__itens[4].nome == 'Cafeteira'), 'A lista de itens do carrinho não corresponde aos itens adicionados'


@pytest.mark.parametrize('situacao', [1, 2])
def test_carrinho_qtd_produtos_fisicos(situacao):
	try:
		carrinho = ac3.Carrinho()
	except Exception:
		raise AssertionError('Erro no construtor da classe Carrinho')
	try:
		prods = []
		prods.append(ac3.ProdutoFisico('Cadeira', 100, 5000))
		prods.append(ac3.ProdutoEletronico('Geladeira', 4000, 42000, 0, 12))
		prods.append(ac3.ProdutoFisico('Mesa', 1000, 15000))
		qtd = 2
		if situacao == 2:
			prods.append(ac3.ProdutoFisico('Copo', 10, 200))
			prods.append(ac3.ProdutoEletronico('Cafeteira', 250, 1500, 0, 24))
			qtd += 1
	except:
		raise AssertionError('Erro ao instanciar os produtos')
	try:
		for prod in prods:
			carrinho.adicionar(prod)
	except:
		raise AssertionError('Erro ao adicionar produtos no carrinho')
	try:
		carrinho.qtd_produtos_fisicos()
	except:
		raise AssertionError('Não existe nenhum método chamado qtd_produtos_fisicos() na classe Carrinho')
	assert carrinho.qtd_produtos_fisicos() == qtd, 'O método qtd_produtos_fisicos() da classe Carrinho retornou resultado incorreto'


@pytest.mark.parametrize('situacao', [1, 2])
def test_carrinho_qtd_produtos_eletronicos(situacao):
	try:
		carrinho = ac3.Carrinho()
	except Exception:
		raise AssertionError('Erro no construtor da classe Carrinho')
	try:
		prods = []
		prods.append(ac3.ProdutoFisico('Cadeira', 100, 5000))
		prods.append(ac3.ProdutoEletronico('Geladeira', 4000, 42000, 0, 12))
		prods.append(ac3.ProdutoFisico('Mesa', 1000, 15000))
		qtd = 1
		if situacao == 2:
			prods.append(ac3.ProdutoEletronico('Computador', 3000, 2500, 0, 12))
			prods.append(ac3.ProdutoEletronico('Cafeteira', 250, 1500, 0, 24))
			qtd += 2
	except:
		raise AssertionError('Erro ao instanciar os produtos')
	try:
		for prod in prods:
			carrinho.adicionar(prod)
	except:
		raise AssertionError('Erro ao adicionar produtos no carrinho')
	try:
		carrinho.qtd_produtos_eletronicos()
	except:
		raise AssertionError('Não existe nenhum método chamado qtd_produtos_eletronicos() na classe Carrinho')
	assert carrinho.qtd_produtos_eletronicos() == qtd, 'O método qtd_produtos_eletronicos() da classe Carrinho retornou resultado incorreto'


@pytest.mark.parametrize('situacao', [1, 2])
def test_carrinho_total_sem_frete(situacao):
	try:
		carrinho = ac3.Carrinho()
	except Exception:
		raise AssertionError('Erro no construtor da classe Carrinho')
	try:
		prods = []
		prods.append(ac3.ProdutoFisico('Cadeira', 100, 5000))
		prods.append(ac3.ProdutoEletronico('Geladeira', 4000, 42000, 0, 12))
		prods.append(ac3.ProdutoFisico('Mesa', 1000, 15000))
		total = 5100
		if situacao == 2:
			prods.append(ac3.ProdutoFisico('Copo', 10, 200))
			prods.append(ac3.ProdutoEletronico('Cafeteira', 250, 1500, 0, 24))
			total += 260
	except:
		raise AssertionError('Erro ao instanciar os produtos')
	try:
		for prod in prods:
			carrinho.adicionar(prod)
	except:
		raise AssertionError('Erro ao adicionar produtos no carrinho')
	try:
		carrinho.total_sem_frete()
	except:
		raise AssertionError('Não existe nenhum método chamado total_sem_frete() na classe Carrinho')
	assert carrinho.total_sem_frete() == total, 'O método total_sem_frete() da classe Carrinho retornou resultado incorreto'


@pytest.mark.parametrize('situacao_desconto', [(1, 0, 5452.1), (2, 0, 5723.68), (1, 20, 4361.68), (2, 25, 4292.76)])
def test_carrinho_total_com_frete(situacao_desconto):
	situacao, desconto, total = situacao_desconto
	try:
		carrinho = ac3.Carrinho()
	except Exception:
		raise AssertionError('Erro no construtor da classe Carrinho')
	try:
		prods = []
		prods.append(ac3.ProdutoFisico('Cadeira', 100, 5000))
		prods.append(ac3.ProdutoEletronico('Geladeira', 4000, 42000, 0, 12))
		prods.append(ac3.ProdutoFisico('Mesa', 1000, 15000))
		if situacao == 2:
			prods.append(ac3.ProdutoFisico('Copo', 10, 200))
			prods.append(ac3.ProdutoEletronico('Cafeteira', 250, 1600, 0, 24))
	except:
		raise AssertionError('Erro ao instanciar os produtos')
	try:
		for prod in prods:
			carrinho.adicionar(prod)
	except:
		raise AssertionError('Erro ao adicionar produtos no carrinho')
	try:
		carrinho.total_com_frete(desconto)
	except:
		raise AssertionError('Não existe nenhum método chamado total_com_frete(desconto) na classe Carrinho')
	assert round(carrinho.total_com_frete(desconto),1) == round(total,1), 'O método total_com_frete(desconto) da classe Carrinho retornou resultado incorreto'


if __name__ == "__main__":
	pytest.main()