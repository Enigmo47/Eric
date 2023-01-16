import pandas as pd
import datetime as dt
import time


nombre = input("Ingresa tu nombre")
print("Hola", nombre, ", que quieres hacer?")
print("1. Sumar dos numeros, 2. Restar dos numeros, 3. Multiplicar dos numeros, 4. Saber la hora, 5. Conocer el día de la semana en el que nací, 6. Salir")
opcion = int(input("Numero del 1 al 6"))
while(opcion != 6):
    if (opcion == 1):
        num1 = int(input("dame un numero"))
        num2 = int(input("dame otro numero"))
        suma = (num1 + num2)
        print(suma)
    elif (opcion == 2):
        num1 = int(input("dame un numero"))
        num2 = int(input("dame otro numero"))
        resta = (num1 - num2)
        print(resta)
    elif (opcion == 3):
        num1 = int(input("dame un numero"))
        num2 = int(input("dame otro numero"))
        prod = (num1 * num2)
        print(prod)
    elif (opcion == 4):
        print(time.strftime('%H:%M:%S', time.localtime()))
    elif (opcion == 5):
        ano = input("Introduce tu año")
        mes = input("Introduce tu mes")
        dia = input("Introduce tu dia")
        fecha = (ano+'-'+mes+'-'+dia)
        temp = pd.Timestamp(fecha)
        print(temp.day_name())
        break
    print("1. Sumar dos numeros, 2. Restar dos numeros, 3. Multiplicar dos numeros, 4. Saber la hora, 5. Conocer el día de la semana en el que nací, 6. Salir")
    opcion = int(input("Opcion: "))