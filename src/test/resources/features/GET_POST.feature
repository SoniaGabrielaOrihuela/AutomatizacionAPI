@Feature
Feature: Crear y Buscar Pedidos de PetStore

  #Happy Path

  @crearPedido
  Scenario Outline: Realizar un Pedido //POST

    When creo el pedido con id "<id>", petId "<petId>", quantity "<quantity>",shipDate "<shipDate>", status "<status>", complete "<complete>"
    Then el código de respuesta es 200
    And el id del pedido es "<id>"
    And el Petid del pedido es "<petId>"
    And la cantidad del pedido es "<quantity>"

    Examples:
      | id  | petId | quantity | shipDate   | status | complete |
      | 100 | 123   | 1        | 2021-08-25 | placed | true     |
      | 101 | 456   | 2        | 2021-08-25 | placed | true     |
      | 102 | 789   | 5        | 2021-08-25 | placed | true     |
      | 103 | 111   | 8        | 2021-08-25 | placed | true     |
      | 104 | 222   | 3        | 2021-08-25 | placed | true     |
      | 105 | 222   | 3        | 2021-08-25 | placed | true     |

  @BuscarPedido
  Scenario Outline: Buscar Pedido //GET

    Given el usuario ingresa a la url "https://petstore.swagger.io/v2/store/order"
    When busca el pedido con id "<id>"
    Then el código de respuesta es 200
    And el id del pedido es "<id>"
    And el Petid del pedido es "<petId>"
    And la cantidad del pedido es "<quantity>"

    Examples:
      | id  | petId | quantity |
      | 100 | 123   | 1        |
      | 101 | 456   | 2        |
      | 102 | 789   | 5        |
      | 103 | 111   | 8        |
      | 104 | 222   | 3        |
      | 105 | 222   | 3        |













