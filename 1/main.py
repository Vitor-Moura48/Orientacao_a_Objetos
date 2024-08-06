def verificar_triangulo(lados):
    lados_ordenados = sorted(lados)
   
    if lados_ordenados[0] + lados_ordenados[1] <= lados_ordenados[2]:
        print('Triângulo Inválido')
        return False
    return True

def area_triangulo(lados):
    semi_perimetro = sum(lados) / 2
    return round( (semi_perimetro * (semi_perimetro-lados[0]) * (semi_perimetro-lados[1]) * (semi_perimetro-lados[2]))**0.5 , 2)

def forma_triangulo(lados):
    combinacoes = len(set(lados))
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
        triangulo = []
        
        while(len(triangulo)) < 3:
            try:
                lado = float( input(f"Lado {len(triangulo) + 1}: ") )
                if lado >= 0:
                    if lado == 0:
                        rodando = False
                        break
                    triangulo.append(lado)
            except:
                print("Ecorreu algum erro, tente novamnete!")
            
        if len(triangulo) == 3 and verificar_triangulo(triangulo):
            print()
            print(f"Area do triângulo: {area_triangulo(triangulo)}")
            print(f"Forma do triângulo: {forma_triangulo(triangulo)}")
    
    print("\nEncerrando Programa")

main()

    
    