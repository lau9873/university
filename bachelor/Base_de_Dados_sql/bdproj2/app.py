import warnings
warnings.filterwarnings("ignore", category=FutureWarning)
from flask import abort, render_template, Flask
import logging
import db

APP = Flask(__name__)

# Start page
@APP.route('/')
def index():
    stats = {}
    x = db.execute('SELECT COUNT(*) AS funcionarios FROM FUNCIONARIO').fetchone()
    stats.update(x)
    x = db.execute('SELECT COUNT(*) AS clientes FROM CLIENTE').fetchone()
    stats.update(x)
    x = db.execute('SELECT COUNT(*) AS artigos FROM ARTIGO').fetchone()
    stats.update(x)
    x = db.execute('SELECT COUNT(*) AS eventos FROM EVENTO').fetchone()
    stats.update(x)
    x = db.execute('SELECT COUNT(*) AS cadeiras FROM CADEIRA').fetchone()
    stats.update(x)
    x = db.execute('SELECT COUNT(*) AS salas_de_estudo FROM SALA_DE_ESTUDO').fetchone()
    stats.update(x)
    x = db.execute('SELECT COUNT(*) AS pisos FROM PISO').fetchone()
    stats.update(x)
    logging.info(stats)
    return render_template('index.html',stats=stats)

# Initialize db
# It assumes a script called db.sql is stored in the sql folder
@APP.route('/init/')
def init(): 
    return render_template('init.html', init=db.init())


# Funcionarios
@APP.route('/funcionarios/')
def list_funcionarios():
    funcionarios = db.execute(
      '''
      SELECT  Nome, TrabFaz, NumMec, Email
      FROM FUNCIONARIO
      ORDER BY Nome
      ''').fetchall()
    return render_template('funcionario-list.html', funcionarios=funcionarios)

@APP.route('/funcionarios/<int:id>/')
def get_funcionario(id):
  funcionario = db.execute(
      '''
      SELECT Nome, TrabFaz, NumMec, Email
      FROM FUNCIONARIO
      WHERE NumMec = %s
      ''', id).fetchone()

  if funcionario is None:
     abort(404, 'NumMec de Funcionario {} does not exist.'.format(id))

  numerosDeTelefoneDoFuncionario = db.execute(
      '''
      SELECT Nome, Telefone 
      FROM FUNCIONARIO NATURAL JOIN NUM_TELEFONE_FUNC 
      WHERE NumMec = %s 
      ORDER BY Nome
      ''', id).fetchall()
 
  limpeza = db.execute(
      '''
      SELECT Nome, Limpeza AS 'Piso', DataHora
      FROM FUNCIONARIO
      WHERE NumMec = %s
      ORDER BY DataHora DESC
      ''', id).fetchall()

  return render_template('funcionario.html', 
            funcionario=funcionario,
            numerosDeTelefoneDoFuncionario = numerosDeTelefoneDoFuncionario,
            limpeza=limpeza )

@APP.route('/funcionarios/search/<expr>/', methods=('GET','POST'))
def search_funcionario(expr):
  search = { 'expr': expr }
  expr = '%' + expr + '%'
  funcionarios = db.execute(
      ''' 
      SELECT Nome, NumMec
      FROM FUNCIONARIO 
      WHERE Nome LIKE %s
      ''', expr).fetchall()
  return render_template('funcionario-search.html',
           search=search,funcionarios=funcionarios)
           
#Clientes
@APP.route('/clientes/')
def list_clientes():
  clientes = db.execute(
      '''
      SELECT Nome, NumMec, Email, Departamento, FimMulta AS 'Fim da Multa'
      FROM CLIENTE
      ORDER BY Nome
      ''').fetchall()
  return render_template('cliente-list.html', clientes=clientes)

@APP.route('/clientes/<int:id>/')
def get_cliente(id):
  cliente = db.execute(
      '''
      SELECT Nome, NumMec, Email, Departamento, FimMulta AS 'Fim da Multa'
      FROM CLIENTE
      WHERE NumMec = %s
      ''', id).fetchone()

  if cliente is None:
     abort(404, 'NumMec de Cliente {} does not exist.'.format(id))

  numerosDeTelefoneDoCliente = db.execute(
      '''
      SELECT Nome, Telefone 
      FROM CLIENTE NATURAL JOIN NUM_TELEFONE_CLIENTE 
      WHERE NumMec = %s 
      ''', id).fetchall()
 
  atendidoPor = db.execute(
      '''
      SELECT FUNCIONARIO.NumMec AS NumMec_Funcionario,
      FUNCIONARIO.Nome AS 'Funcionario', ATENDIDO_POR.Tipo, ATENDIDO_POR.DataHora       
      FROM FUNCIONARIO JOIN ATENDIDO_POR JOIN CLIENTE ON(Funcionario=FUNCIONARIO.NumMec AND Cliente=CLIENTE.NumMec) 
      WHERE CLIENTE.NumMec= %s
      ORDER BY DataHora DESC
      ''', id).fetchall()
  
  inscricao = db.execute(
      '''
      SELECT CLIENTE.Nome AS NomeC, EVENTO.Codigo, EVENTO.Nome AS NomeE, EVENTO.Tipo AS 'Tipo de Evento', NumEntrada AS 'Numero de Entrada'     
      FROM INSCRICAO JOIN EVENTO JOIN CLIENTE ON(Evento=Codigo AND Cliente=NumMec) 
      WHERE CLIENTE.NumMec = %s
      ORDER BY EVENTO.Codigo

      ''', id).fetchall() 
  
  artigoQueRequisitou = db.execute(
      '''
      SELECT CLIENTE.Nome, ARTIGO.Titulo, Codigo     
      FROM CLIENTE JOIN ARTIGO ON(Requisitado=NumMec) 
      WHERE CLIENTE.NumMec = %s
      ''', id).fetchall()
  
  salaDeEstudoReservada = db.execute(
      '''
      SELECT CLIENTE.Nome, Codigo, Inicio, Fim, Capacidade, NumPCs    
      FROM SALA_DE_ESTUDO JOIN CLIENTE ON(Reservou=Codigo) 
      WHERE CLIENTE.NumMec= %s
      ''', id).fetchall()    
   

  return render_template('cliente.html', 
            cliente=cliente,
            numerosDeTelefoneDoCliente = numerosDeTelefoneDoCliente,
            atendidoPor=atendidoPor,
            inscricao=inscricao,
            artigoQueRequisitou=artigoQueRequisitou,
            salaDeEstudoReservada =salaDeEstudoReservada)

@APP.route('/clientes/search/<expr>/', methods=('GET','POST'))
def search_cliente(expr):
  search = { 'expr': expr }
  expr = '%' + expr + '%'
  clientes = db.execute(
        ''' 
        SELECT Nome, NumMec, Email, Departamento, FimMulta AS 'Fim da Multa'
        FROM CLIENTE 
        WHERE Nome LIKE %s
        ''', expr).fetchall()

  return render_template('cliente-search.html', 
           search=search,clientes=clientes)

#ARTIGOS
@APP.route('/artigos/')
def list_artigos():
	artigos = db.execute(
		 '''
		 SELECT Tipo, Codigo, Titulo, Autor, Volume
		 FROM ARTIGO
		 ORDER BY Tipo
		 ''').fetchall()
	return render_template('artigo-list.html', artigos=artigos)

@APP.route('/artigos/<int:id>/')
def get_artigo(id):
  artigo = db.execute(
      '''
      SELECT Tipo, Codigo, Titulo, Autor, Volume
      FROM ARTIGO
      WHERE Codigo = %s
      ''', id).fetchone()

  if artigo is None:
     abort(404, 'Codigo de Artigo {} does not exist.'.format(id))

  clienteQueRequisitou = db.execute(
      '''
      SELECT Tipo AS 'Tipo de Artigo', Titulo AS 'Titulo do Artigo',CLIENTE.Nome, NumMec, DataHora 
      FROM ARTIGO JOIN CLIENTE ON(Requisitado=NumMec)
      WHERE ARTIGO.Codigo = %s  
      ORDER BY DataHora
      ''', id).fetchall()
  localizacao = db.execute(
      '''
      SELECT Tipo AS 'Tipo de Artigo',Titulo AS 'Titulo do Artigo',Localizacao, Estante, Seccao
      FROM ARTIGO
      WHERE ARTIGO.Codigo = %s 
      ''', id).fetchone()
  areaCientifica = db.execute(
     '''
     SELECT  Area 
     FROM AREA_CIENTIFICA JOIN ARTIGO ON(AREA_CIENTIFICA.Artigo=ARTIGO.Codigo)
     WHERE ARTIGO.Codigo = %s 
     ORDER BY Area
     ''', id).fetchall()
  recomendadoPorCadeira = db.execute(
	 '''
     SELECT CADEIRA.Nome, CADEIRA.Codigo, Departamento, GrauObrigatoriadade, Temas
     FROM ARTIGO JOIN RECOMENDADO_POR_CADEIRA JOIN CADEIRA  ON(Artigo=ARTIGO.Codigo AND Cadeira=CADEIRA.Codigo)
     WHERE ARTIGO.Codigo = %s 
     ORDER BY Cadeira
     ''', id).fetchall()
  usadoPorEvento = db.execute(
	 '''
	 SELECT EVENTO.Codigo AS 'Cod_do_Evento', EVENTO.Nome AS 'Nome_Evento', EVENTO.Tipo AS 'Tipo_Evento',Justificacao AS 'Motivo_do_Uso'
	 FROM ARTIGO JOIN USADO_POR_EVENTO JOIN EVENTO ON(Evento=EVENTO.Codigo AND Artigo=ARTIGO.Codigo)
	 WHERE ARTIGO.Codigo= %s
	 ORDER BY 'TipoEvento';
     ''', id).fetchall()
  return render_template('artigo.html', 
            artigo=artigo,
            clienteQueRequisitou = clienteQueRequisitou,
            localizacao=localizacao,
            areaCientifica=areaCientifica,
            recomendadoPorCadeira=recomendadoPorCadeira,
            usadoPorEvento=usadoPorEvento)

@APP.route('/artigos/search/<expr>/', methods=('GET','POST'))
def search_artigo(expr):
  search = { 'expr': expr }
  expr = '%' + expr + '%'
  artigos = db.execute(
			''' 
			  SELECT Tipo, Codigo, Titulo, Autor, Volume
			  FROM ARTIGO 
			  WHERE Tipo LIKE %s
			  ORDER BY Titulo
			  ''', expr).fetchall()
  return render_template('artigo-search.html',
           search=search,artigos=artigos)





# PISOS
@APP.route('/pisos/')
def list_pisos():
    pisos = db.execute(
      '''
      SELECT Num,NumEspacoLeitura
      FROM PISO
      ''').fetchall()
    return render_template('pisos-list.html', pisos=pisos)


@APP.route('/pisos/<int:id>/')
def get_piso(id):
  piso = db.execute(
      '''
      SELECT Num,NumEspacoLeitura AS 'Espacos_de_Leitura'
      FROM PISO
      WHERE Num = %s
      ''', id).fetchone()

  if piso is None:
     abort(404, 'Piso {} does not exist.'.format(id))
  if not (piso[id] is None):
		salasDeEstudo = db.execute(
		  '''
		  SELECT 
		  COUNT(*) AS 'Numero_de_Salas_de_Estudo'
		  FROM PISO JOIN SALA_DE_ESTUDO ON(Num=Localizado) 
		  WHERE Num = %s 
		  ''', id).fetchall()

	  artigos = db.execute(
		  '''
		  SELECT Localizacao AS Piso, COUNT(*) AS 'NumdeArtigos'
		  FROM ARTIGO
		  WHERE Localizacao = %s
		  ''', id).fetchall()

	  areasCientificas = db.execute(
		  ''' 
		  SELECT PISO.Num, COUNT(*) AS 'Numero_de_Areas_Cientificas'
		  FROM PISO JOIN AREAS_PISO ON(Piso=Num)
		  WHERE PISO.Num = %s
		  ''', id).fetchall();
	  return render_template('piso.html', 
			   piso=piso, 
			   salasDeEstudo=salasDeEstudo, 
			   artigos=artigos, 
			   areasCientificas=areasCientificas)


#Listagem dos artigos, que não são calculadora, requsitados
@APP.route('/ArtigosRequisitados/')
def list_Requisitados():
	Requisitados = db.execute(
	'''
	SELECT ARTIGO.Codigo, ARTIGO.Titulo, ARTIGO.DataHora, CLIENTE.NumMec 
			FROM ARTIGO JOIN CLIENTE ON(ARTIGO.Requisitado = CLIENTE.NumMec)
			ORDER BY ARTIGO.DataHora, ARTIGO.Titulo;
	'''
	).fetchall()
	return render_template('requisitados-list.html', Requisitados=Requisitados)

