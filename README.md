# Describing the UML diagrams -

## Activity Diagram - 
First the customer sends a request for an order, upon which the system confirms the request. After confirming the type of the order is checked. Order is dispatched and system terminates if it's either of type "Normal" or "Special", else system simply terminates without dispatching.

## Class Diagram -
Static relations between various objects in the system is described here. Many orders can be associated to a single customer. Also, the classes SpecialOrder and NormalOrder are specialized classes whereas the Order class is the general class.

## Sequence Diagram - 
Interaction between the four objects in the system is shown here. To initialize, the customer sends an order request. The system confirms the order and it's type, in this case it's a Special Order. System then dispatches the order and it's returned to the customer.

## Use Case Diagram - 
Interaction of external actor Customer is shown here with the Order System, along with the relationship between specific order types and the general order description, using the "extends" relationship.