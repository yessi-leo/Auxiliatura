class Persona:
    def __init__(self, nombre="", apellido="", ci=""):
        self.nombre = nombre
        self.apellido = apellido
        self.ci = ci
    
    def leer(self):
        self.nombre = input("Ingrese nombre: ")
        self.apellido = input("Ingrese apellido: ")
        self.ci = input("Ingrese ci: ")
    
    def mostrar(self):
        print("Nombre:", self.nombre)
        print("Apellido:", self.apellido)
        print("Ci:", self.ci)


class Cliente(Persona):
    def __init__(self, nro_compra="", id_cliente="", nombre="", apellido="", ci=""):
        super().__init__(nombre, apellido, ci)
        self.nro_compra = nro_compra
        self.id_cliente = id_cliente
    
    def leer(self):
        super().leer()
        self.nro_compra = input("Numero de compra: ")
        self.id_cliente = input("ID del cliente: ")
    
    def mostrar(self):
        print("\n--- Datos del Cliente ---")
        super().mostrar()
        print("Numero de compra:", self.nro_compra)
        print("ID Cliente:", self.id_cliente)


class Jefe(Persona):
    def __init__(self, sucursal="", tipo="", nombre="", apellido="", ci=""):
        super().__init__(nombre, apellido, ci)
        self.sucursal = sucursal
        self.tipo = tipo
    
    def leer(self):
        super().leer()
        self.sucursal = input("Sucursal: ")
        self.tipo = input("Tipo: ")
    
    def mostrar(self):
        print("\n--- Datos del Jefe ---")
        super().mostrar()
        print("Sucursal:", self.sucursal)
        print("Tipo:", self.tipo)


def main():
    print("\n--- REGISTRO DE CLIENTE ---")
    cliente = Cliente()
    cliente.leer()
    
    print("\n--- REGISTRO DE JEFE ---")
    jefe = Jefe()
    jefe.leer()
    
    cliente.mostrar()
    jefe.mostrar()


if __name__ == "__main__":
    main()