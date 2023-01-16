from ast import Num
from inspect import CO_NOFREE
import random
import time

preguntas = ["Entra duro y grande en la boca, pero sale blando y pequeño. ¿Qué es?",
            "Estando roto es más útil que sin romperse. ¿Qué es?",
            "Te paras cuando está verde y continúas cuando está rojo. ¿Qué es?",
            "Hay algo que, aunque te pertenezca, la gente siempre lo utiliza más que tú. ¿Qué es?",
            "Soy alto siendo joven y corto cuando soy viejo. Resplandezco con la vida y el viento es mi mayor enemigo. ¿Qué soy?",
            "¿Qué monte era el más alto del mundo antes de descubrir el Everest?",
            "Estoy en todo pese a estar en nada. ¿Qué soy?",
            "Crezco a pesar de no estar vivo. No tengo pulmones, pero para vivir necesito el aire. El agua, aunque no tenga boca, me mata. ¿Qué soy?",
            "¿Cuántos 9 hay entre el 1 y el 100?","Tengo un arco, no soy flecha y sí de madera."]
respuestas = ["chicle","huevo","sandia","tu nombre","vela","everest","letra","fuego","20","violin"]
contador = 0
acertijos = ["¿Cuál es el río más largo de España?",
            "¿Cuál es el río más largo de la península ibérica?",
            "¿Cuál es el río más largo del mundo?",
            "¿Cuál es la montaña más alta de España?",
            "¿Cuál es la montaña más alta del mundo?",
            "¿Cuál es el océano más grande?",
            "¿Cuál es el país con más extensión?",
            "¿Cuál es el país más poblado?"]
soluciones = ["ebro", "tajo", "amazonas","teide","everest","pacifico","rusia","india"]
salas = ["1 = norte", "2 = este", "3 = sur", "4 = oeste"]


print("Un aventurero, se encuentra en una sala central de una mazmorra y deberá elegir una de las siguientes opciones")
opcion= -1
while(opcion != 5 and len(salas) > 0):
    print(salas)
    opcion = int(input("introdizca opcion"))
    if (opcion == 1):
        print("El aventurero eligió la sala norte, donde apareció un monstruo que se avalanzó sobre el aventurero")
        enemigo = random.randint(0, 100)
        if (enemigo >= 90):
            print("El aventurero, ha muerto...")
            break
        else:
            atacar =input(" El aventurero sobrevivió, contraatacará? Y/N")
            if (atacar == "Y"):
                ataque = random.randint(0, 100)
                if (ataque >= 60):
                    print("El aventurero acabó con el monstruo y volvió a la sala inicial a la espera de su siguiente reto...")
                    contador = contador + 1
                    salas.remove("1 = norte")
                else:
                    print("El aventurero falló el ataque torpemente, al hacerlo este se resvaló y el monstruo acabó con él")
                    
            else:
                print("El aventurero, asustado ante tal peligro decidió volver a la sala central para afrontar otro desafio antes de volver")
    elif (opcion == 2):
        print("El aventurero se adentró en la sala este, donde se encontró con un sabio azul, este le hizo una pregunta....")
        numP = random.randint(0,9)
        print(str(preguntas[numP]))
        respuesta = input("Respuesta: ")
        if(respuestas[numP].lower() in respuesta.lower()):
            print("El sabio quedó atónito ante la respuesta correcta del aventutrero y le permitio volver victorioso a la sala central")
            contador = contador + 1
            salas.remove("2 = este")
        else:
            print("El sabio miró con enfado al aventurero y le lanzó un rayo que acabó con su vida")
            break
    elif (opcion == 3):
        salas.remove("3 = sur")
        print("El aventurero se adentró en la sala sur, donde hayó un gran cofre de madera en el centro de la sala, al entrar se cerró de golpe la puerta de la sala , a si que asumió que no quedó otra alternativa más que abrirlo, para ello hay que tener suerte y que tras darle a un botón el numero que aparezca sea mayor que 63, ¿El aventurero logrará abrirlo?")
        contador = contador + 1
        while True:
            cofre = random.randint(0,100)
            print("Has sacado: ",cofre)
            if cofre>=63:
                print("El aventurero contempló el cofre, este empezó a abrirse y a deslumbrarlo con una cegadora luz, en su interior se hallaba una gran llave que le permitió volver a la sala inicial")
                
                break
            else:
                print("No funcionó el número y el aventurero ha de esperar 20 segundos")
                time.sleep(2)
           
    elif (opcion == 4):
        print("El aventurero se adentró en la sala oeste, donde se encontró con un sabio rojo, este le hizo una pregunta....")
        numP = random.randint(0,7)
        print(acertijos[numP])
        solucion = input("Respuesta: ")
        if(soluciones[numP].lower() in solucion.lower()):
            print("El sabio quedó atónito ante la respuesta correcta del aventutrero y le permitio volver victorioso a la sala central")
            contador = contador + 1
            salas.remove("4 = oeste")
        else:
            print("El sabio miró con enfado al aventurero y le lanzó un rayo que acabó con su vida")
            break
    if(contador == 4):
        print("El aventurero consiguió escapar victorioso de la mazmorra, ahora gozará de la gloria y de un merecido descanso")