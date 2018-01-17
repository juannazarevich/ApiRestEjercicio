# Ejercicio

El servicio consta de un endpoint que devolverá la información de un producto.
Como los endpoints del que extrae la información no están disponibles, se utilizaron dos implementaciones de una misma interfaz, la que se conecta a los servicios externos y una mockeada que devolvera casos de prueba para poder ver el formato de respuesta.

El endpoint disponible para el primer caso es `http://localhost:8080/product/{id}`

Al endpoint mockeado se podrá acceder agregando el siquien query param `http://localhost:8080/product/{id}?istest=true`

Se agregaron tres id's(1,2 y 3) de prueba en la implementación  mockeada.

Ejemplo de response:

    {
    "id": "1",
    "name": "Heladera",
    "description": "Una heladera",
    "price": 100,
    "list_price": 78,
    "reviews": [
        {
            "id": "a",
            "user": "elepe",
            "review": "Buenisimo"
        }
    ]
	}

Además se agregan al proyecto test unitarios utilizando Mockito para poder mockear las llamadas a los servicios externos.
