# Import necessary modules
import sys
from PyQt6.QtWidgets import (QApplication, QWidget, QLabel
, QGridLayout,QPushButton,QComboBox,QSizePolicy)
from PyQt6.QtWidgets import (QApplication, QMainWindow, 
    QMessageBox, QTextEdit, QFileDialog, QInputDialog, 
    QFontDialog, QColorDialog)
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QFont
from ast import Num
from inspect import CO_NOFREE
import random
import time

contador = 0

class MainWindow(QWidget):



	def __init__(self):
		super().__init__() 
		self.initializeUI()

	def initializeUI(self):
		"""Set up the application's GUI."""

		self.setWindowTitle("La Mazmorra de Eric")

		self.setFixedSize(380,440)
		self.setMaximumSize(800,800)
		self.setMinimumSize(180,180)

		self.UiComponents()
		self.show()

	def UiComponents(self):
		
		layoutPrincipal = QGridLayout()
		layoutSalas=QGridLayout()
		layoutOp=QGridLayout()

		combo = QComboBox(self)

		layoutPrincipal.addWidget(combo,0,0)
		layoutPrincipal.addLayout(layoutSalas,1,0)
		layoutPrincipal.addLayout(layoutOp,1,1)

		layoutSalas.addLayout(layoutSalas,0,0)
		
		combo.addItem("Jugar")
		combo.addItem("Salir")
		
		combo.currentTextChanged.connect(self.accion)
		
 
		# creating a push button
		pushS = QPushButton("Sala Sur", self)
		pushS.setSizePolicy(
			QSizePolicy.Policy.Expanding,
			QSizePolicy.Policy.Expanding,	
		)
		# creating a push button
		pushO = QPushButton("Sala Oeste", self)
		pushO.setSizePolicy(
			QSizePolicy.Policy.Expanding,
			QSizePolicy.Policy.Expanding
		)
		# creating a push button
		pushC = QPushButton("Sala central", self)
		pushC.setSizePolicy(
			QSizePolicy.Policy.Expanding,
			QSizePolicy.Policy.Expanding
		)
		# creating a push button
		pushE = QPushButton("Sala Este", self)
		pushE.setSizePolicy(
			QSizePolicy.Policy.Expanding,
			QSizePolicy.Policy.Expanding
		)
		# creating a push button
		pushN = QPushButton("Sala norte", self)
		pushN.setSizePolicy(
			QSizePolicy.Policy.Expanding,
			QSizePolicy.Policy.Expanding
		)

		pushS.clicked.connect(self.actionS)
		pushO.clicked.connect(self.actionO)
		pushC.clicked.connect(self.actionC)
		pushE.clicked.connect(self.actionE)
		pushN.clicked.connect(self.actionN)

		#asigno al layout de salas los botones de las salas
		layoutSalas.addWidget(pushN,0,1)
		layoutSalas.addWidget(pushO,1,0)
		layoutSalas.addWidget(pushC,1,1)
		layoutSalas.addWidget(pushE,1,2)
		layoutSalas.addWidget(pushS,2,1)
		
		self.setLayout(layoutPrincipal)

	def accion(self, text):
		if(text=="Jugar"):
			self.setGeometry(150,150,380,440)
		if(text=="Salir"):
			sys.exit(app.exec())
	

	
	def actionS(self):
		# appending label text
		QMessageBox.information(self, "Sala Sur", 
            "El aventurero abrió un cofre",
			QMessageBox. StandardButton.Ok, 
            QMessageBox.StandardButton.Ok)
		contador = contador + 1
 
	def actionO(self):
		QMessageBox.information(self, "Sala oeste", 
            "El aventurero resolvió una adivinanza",
			QMessageBox. StandardButton.Ok, 
            QMessageBox.StandardButton.Ok)
	contador = contador + 1
 
	def actionC(self):
		QMessageBox.information(self, "Sala Central", 
            "El aventurero no puede quedarse en la sala central, ha de avanzar a una sala",
			QMessageBox. StandardButton.Ok, 
            QMessageBox.StandardButton.Ok)
 
	def actionE(self):
		QMessageBox.information(self, "Sala Este", 
            "El aventurero adivinó otra adivinanza",
			QMessageBox. StandardButton.Ok, 
            QMessageBox.StandardButton.Ok)
	contador = contador + 1
 
	def actionN(self):
		QMessageBox.information(self, "Sala Norte", 
            "El aventurero mató a un mounstruo",
			QMessageBox. StandardButton.Ok, 
            QMessageBox.StandardButton.Ok)
	contador = contador + 1
		

#En vez de felicitar al jugador cierra el juego cuando la puntuación es igual a 4
if(contador == 4):
	QMessageBox.information("Ganaste",
			QMessageBox. StandardButton.Ok, 
            QMessageBox.StandardButton.Ok)

if __name__ == '__main__':
	app = QApplication(sys.argv)
	window = MainWindow()
	sys.exit(app.exec())