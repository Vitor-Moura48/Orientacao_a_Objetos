class FormaGeometrica:
    def __init__(self, lados) -> None:
        self.lados = lados

    def calcular_semi_perimetro(self):
        if len(self.lados) >= 3:
            self.semi_perimetro = sum(self.lados) / 2

class Triangulo(FormaGeometrica):
    def __init__(self, lados) -> None:
        FormaGeometrica.__init__(self, lados)

    def verificar_triangulo(self):
        lados_ordenados = sorted(self.lados)
    
        if len(self.lados) != 3 or lados_ordenados[0] + lados_ordenados[1] <= lados_ordenados[2]:
            print('Triângulo Inválido')
            return False
        return True

    def area_triangulo(self):
        self.calcular_semi_perimetro()
        return round( (self.semi_perimetro * (self.semi_perimetro-self.lados[0]) * (self.semi_perimetro-self.lados[1]) * (self.semi_perimetro-self.lados[2]))**0.5 , 2)

    def forma_triangulo(self):
        combinacoes = len(set(self.lados))
        match combinacoes:
            case 1:
                return "Equilátero"
            case 2:
                return "Isoceles"
            case 3:
                return "Escaleno"

def main():
    rodando = True
    while rodando:
        print("\n*** Informe os lados do triângulo [0 = Sair] ***\n")
        lados = []
        
        while(len(lados)) < 3:
            try:
                lado = float( input(f"Lado {len(lados) + 1}: ") )
                if lado >= 0:
                    if lado == 0:
                        rodando = False
                        break
                    lados.append(lado)
            except:
                print("Ecorreu algum erro, tente novamnete!")
        
        triangulo = Triangulo(lados)
        if triangulo.verificar_triangulo():
            print()
            print(f"Area do triângulo: {triangulo.area_triangulo()}")
            print(f"Forma do triângulo: {triangulo.forma_triangulo()}")
    
    print("\nEncerrando Programa")

main()

    
    