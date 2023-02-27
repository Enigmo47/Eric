import sys
import random
from PyQt6.QtWidgets import QApplication, QMainWindow, QLabel, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        # Crear una etiqueta para mostrar la sala actual
        self.sala_label = QLabel(self)
        self.sala_label.setGeometry(50, 50, 200, 50)

        # Crear un botón para avanzar a la siguiente sala
        self.siguiente_boton = QPushButton('Siguiente', self)
        self.siguiente_boton.setGeometry(50, 100, 200, 50)
        self.siguiente_boton.clicked.connect(self.siguiente_sala)

        # Crear un botón para realizar una acción en la sala actual
        self.accion_boton = QPushButton('Realizar Acción', self)
        self.accion_boton.setGeometry(50, 150, 200, 50)
        self.accion_boton.clicked.connect(self.realizar_accion)

        # Inicializar el juego
        self.sala_actual = 1
        self.actualizar_sala()

    def siguiente_sala(self):
        # Avanzar a la siguiente sala
        self.sala_actual += 1
        if self.sala_actual > 4:
            # El jugador ha completado todas las salas
            self.sala_label.setText('¡Felicidades, has completado el juego!')
            self.siguiente_boton.setEnabled(False)
            self.accion_boton.setEnabled(False)
        else:
            self.actualizar_sala()

    def realizar_accion(self):
        # Realizar una acción en la sala actual
        if self.sala_actual == 1:
            # En la primera sala hay un monstruo al que derrotar
            if random.randint(0, 1) == 0:
                self.sala_label.setText('¡Has derrotado al monstruo!')
            else:
                self.sala_label.setText('¡El monstruo te ha vencido! Intenta de nuevo.')
        elif self.sala_actual == 2 or self.sala_actual == 3:
            # En la segunda y tercera sala hay un acertijo aleatorio
            respuesta = random.randint(1, 10)
            mensaje = f'¿Cuál es la respuesta a {respuesta} + {respuesta}?'
            if int(self.ingreso_respuesta(mensaje)) == respuesta * 2:
                self.sala_label.setText('¡Has resuelto el acertijo!')
            else:
                self.sala_label.setText('¡Respuesta incorrecta! Intenta de nuevo.')
        elif self.sala_actual == 4:
            # En la cuarta sala hay un cofre que requiere un número mayor a 60 para abrirlo
            numero = int(self.ingreso_respuesta('Ingresa un número mayor a 60:'))
            if numero > 60:
                self.sala_label.setText('¡Has abierto el cofre y ganado el juego!')
                self.siguiente_boton.setEnabled(False)
                self.accion_boton.setEnabled(False)
            else:
                self.sala_label.setText('¡Número incorrecto! Intenta de nuevo.')

    def actualizar_sala(self):
        # Actualizar la etiqueta de la sala actual
        if self.sala_actual == 1:
            self.label_sala.setText('Sala 1 - Monstruo')
        elif self.sala_actual == 2:
            self.label_sala.setText('Sala 2 - Acertijo')
        elif self.sala_actual == 3:
            self.label_sala.setText('Sala 3 - Acertijo')
        elif self.sala_actual == 4:
            self.label_sala.setText('Sala 4 - Cofre')
        else:
            self.label_sala.setText('Sala desconocida')

if name == 'main':
# Crear la aplicación y la ventana principal
app = QApplication(sys.argv)
window = MainWindow()
window.setGeometry(100, 100, 300, 250)
window.show()
