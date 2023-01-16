import collections
from email.policy import default
from itertools import count
from re import A
from time import sleep
import PyPDF2
import re
from collections import defaultdict

texto = []

pdfFileObj=open('Constitucion.pdf','rb')#lee en binario el archivo

pdfReader= PyPDF2.PdfFileReader(pdfFileObj) #lee el fichero abierto

pags=pdfReader.numPages #numero de paginas del PDF

for i in range(pags):
    texto.append(pags)
    pageObj=pdfReader.getPage(i) # almacenamos el numero de paginas
    text=pageObj.extractText() # obtenemos el texto del archivo PDF
    file1=open(r"./ConstitucionCASTELLANO.txt", "a")
    file1.writelines(text)
    
#print(texto)
pdfFileObj.close()
#contar palabras

count = {}
contador = 0
contador1 = 0
masP = []

for x in open('ConstitucionCASTELLANO.txt').read().split():
    if x in count:
        count[x] += 1
        contador = contador+1
    else:
        count[x] = 1
        contador = contador+1
        contador1 = contador1+1
for word, times in count.items(): 
    print("[%s, %d]" % (word, times))
    if (times >= 200):
        popular = ("[%s, %d]" % (word, times))
        masP.append(popular)

print(popular)
print(contador)
print(contador1)
print("CUENTA LETRAS: ")

archivo = open(r"./ConstitucionCASTELLANO.txt", "rt")
datos = archivo.read()
palabras = datos.split()

text = datos
chars = defaultdict(int)
cuentaLetras=0
porcentaje=0


#copiar count de arriba
for char in text:
    if(char != " " and char != '\n'): # si no es espacio en blanco o salto de linea lo añade
        chars[char] += 1
        cuentaLetras+=1
print("Total de letras: ", cuentaLetras)
media = cuentaLetras/len(palabras)
print("Longitud media de la palabra: ", media)

for char in chars:
    if(char != "" and char != '\n'):
        print(char, ":", (chars[char]/cuentaLetras)*100, "%")
        porcentaje+=(chars[char]/cuentaLetras)*100


print(porcentaje)




masPS = str(masP)
mediaS = str(media)
contadorS = str(contador)
contador1S = str(contador1)
nombre = "ConstitucionCASTELLANO"

file1 = open('ConstitucionCASTELLANO.txt', 'r+')
file1.truncate(0)

json = ["El nombre del archivo es: ", nombre," El numero de palabras es: ",contadorS, "  El numero de palabras distintas es: ",contador1S, " La longitud media de las palabras es: ",mediaS," Las palabras mas populares son: ", masPS]
file2=open(r"./ConstitucionCASTELLANO.json", "w")
file2.writelines(json)
