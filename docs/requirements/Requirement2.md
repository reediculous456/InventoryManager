# Requirement 2: Add an item to an inventory

## Scenario

As a user, I should be able to add items to my inventory so I can keep track of who is using what and how much of each item I have.

## Assumptions

The item being added has already been created

## Examples

### Example 1

1. **Given** The item exists within the system.
2. **When** The user adds an item to an inventory.
3. **When** The user submits the item into the inventory
4. **Then** The system successfully adds and saves the item with in that inventory.

### Example 2

1. **Given** The item does not exist within the system
2. **When** The user adds an item to an inventory.
3. **When** The user submits the item into the inventory
4. **Then** The system will throw an error stating that the item is not in the system and needs to be created

### Example 3

1. **Given** The item is already in the inventory
2. **When** The user adds an item to an inventory.
3. **When** The user submits the item into the inventory
4. **Then** The system will add 1 to the amount of that item within the system
