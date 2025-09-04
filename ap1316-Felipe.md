Aluno  : Felipe Nunes Campos / 202403069

    Atividade prática


1 - exemplo de alto acoplamento em python (classes encadeadas)

class Pedido:
    def __init__(self, id_pedido, cliente, itens):
        self.id = id_pedido
        self.cliente = cliente
        # Detalhe interno de implementação: uma lista de tuplas
        self._itens = itens 
        self._valor_total = self._calcular_total()

    def _calcular_total(self):
        return sum(preco for produto, preco in self._itens)

class GeradorNotaFiscal:
    def gerar_nota(self, pedido: Pedido):
        print("--- NOTA FISCAL ---")
        print(f"Cliente: {pedido.cliente}")
        print(f"Pedido ID: {pedido.id}")
        print("Itens:")
        
        for produto, preco in pedido._itens:
            print(f" - {produto}: R$ {preco:.2f}")
        
        print(f"Valor Total: R$ {pedido._valor_total:.2f}")
        print("-------------------")


1 - exemplo de baixo acoplamento (classes modulares)

class Pedido:
    def __init__(self, id_pedido, cliente, itens):
        self.id = id_pedido
        self.cliente = cliente
        self._itens = itens
        self._valor_total = self._calcular_total()

    def _calcular_total(self):
        return sum(preco for produto, preco in self._itens)

    def get_valor_total(self):
        """Retorna o valor total do pedido."""
        return self._valor_total

    def get_itens_formatados(self):
        """Retorna uma lista de strings formatadas para os itens."""
        return [f" - {produto}: R$ {preco:.2f}" for produto, preco in self._itens]

class GeradorNotaFiscal:
    def gerar_nota(self, pedido: Pedido):
        print("--- NOTA FISCAL ---")
        print(f"Cliente: {pedido.cliente}")
        print(f"Pedido ID: {pedido.id}")
        print("Itens:")
        
        for item_formatado in pedido.get_itens_formatados():
            print(item_formatado)
        
        print(f"Valor Total: R$ {pedido.get_valor_total():.2f}")
        print("-------------------")


2 - exemplo de baixa coesao 

import json

class GerenciadorDeUtilidades:
    def validar_email(self, email):
        """Valida o formato de um e-mail."""
        print(f"Validando e-mail: {email}")
        return "@" in email and "." in email

    def salvar_usuario_no_banco(self, usuario):
        """Salva um dicionário de usuário no banco de dados."""
        print(f"Salvando usuário '{usuario['nome']}' no banco...")
        # Lógica de banco de dados aqui...
    
    def ler_configuracao_json(self, caminho_arquivo):
        """Lê um arquivo de configuração JSON."""
        print(f"Lendo arquivo de configuração: {caminho_arquivo}")
        with open(caminho_arquivo, 'r') as f:
            return json.load(f)

    def converter_para_maiusculas(self, texto):
        """Converte um texto para maiúsculas."""
        return texto.upper()


2 - exemplo de alta coesao 
  
import json

class ServicoDeValidacao:
    def validar_email(self, email):
        """Valida o formato de um e-mail."""
        print(f"Validando e-mail: {email}")
        return "@" in email and "." in email

class RepositorioDeUsuario:
    def salvar(self, usuario):
        """Salva um dicionário de usuário no banco de dados."""
        print(f"Salvando usuário '{usuario['nome']}' no banco...")
        # Lógica de banco de dados aqui...

class LeitorDeConfiguracao:
    def ler_json(self, caminho_arquivo):
        """Lê um arquivo de configuração JSON."""
        print(f"Lendo arquivo de configuração: {caminho_arquivo}")
        with open(caminho_arquivo, 'r') as f:
            return json.load(f)

def converter_para_maiusculas(texto):
    """Converte um texto para maiúsculas."""
    return texto.upper()


3 - exemplo de falta de emcapsulamento 

class Produto:
    def __init__(self, nome, quantidade_inicial):
        self.nome = nome
        self.estoque = quantidade_inicial

    def __str__(self):
        return f"{self.nome} - Estoque: {self.estoque}"

caneta = Produto("Caneta Azul", 100)
print(caneta)

print("Vendendo 20 canetas...")
caneta.estoque -= 20

print("Erro de digitação do operador, definindo estoque negativo...")
caneta.estoque = -50 

print(caneta)

3 - exemplo com emcapsulamento 

class Produto:
    def __init__(self, nome, quantidade_inicial):
        self.nome = nome
        self._estoque = max(0, quantidade_inicial)

    def get_estoque(self):
        """Retorna a quantidade em estoque."""
        return self._estoque

    def adicionar_estoque(self, quantidade):
        """Adiciona uma quantidade ao estoque."""
        if quantidade <= 0:
            raise ValueError("A quantidade a ser adicionada deve ser positiva.")
        self._estoque += quantidade
        print(f"{quantidade} unidades de '{self.nome}' adicionadas.")
    
    def remover_estoque(self, quantidade):
        """Remove uma quantidade do estoque, com validação."""
        if quantidade <= 0:
            raise ValueError("A quantidade a ser removida deve ser positiva.")
        if quantidade > self._estoque:
            raise ValueError("Estoque insuficiente.")
        self._estoque -= quantidade
        print(f"{quantidade} unidades de '{self.nome}' removidas.")

    def __str__(self):
        return f"{self.nome} - Estoque: {self._estoque}"

caneta = Produto("Caneta Azul", 100)
print(caneta)

print("Vendendo 20 canetas...")
caneta.remover_estoque(20)
print(caneta)

try:
    print("Tentando setar estoque negativo diretamente (não vai funcionar)...")
    # caneta._estoque = -50 # Má prática, mas mesmo assim não é o caminho ideal
    print("Tentando remover mais do que o disponível...")
    caneta.remover_estoque(90) 
except ValueError as e:
    print(f"ERRO PREVISTO: {e}")

print(caneta)
