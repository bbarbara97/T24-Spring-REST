# T24-Spring-REST


GET localhost:8181/api/trabajadores/nombre/Marta
[
    {
        "id": 1,
        "nombre": "Marta",
        "trabajo": "Programador",
        "salario": 0.0
    }
]

GET localhost:8181/api/trabajadores/4
{
    "id": 4,
    "nombre": "Facundo",
    "trabajo": "Arquitecto",
    "salario": 0.0
}

PUT localhost:8181/api/trabajadores/4
{
    "id": 4,
    "nombre": "Facundo",
    "trabajo": "CEO",
    "salario": 100000.0
}

DELETE localhost:8181/api/trabajadores/4

GET localhost:8181/api/trabajadores
