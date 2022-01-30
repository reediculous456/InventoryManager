# Requirement 3: Assign items to an employee or customer

## Scenario

As a user, I should be able to assign items to employees so that way I can know who has and where all of the items I have are.

## Assumptions

1. The item that is being assigned is in the system.
2. The employee that the item is being assigned to is in the system.

## Examples

### Example 1

1. **Given** The item exists in the system.
2. **When** The user adds an item to a user and submits.
3. **Then** The item is assigned to employee the user chose and gives a screen telling the user that the item has been assigned to that user.

### Example 2

1. **Given** The item does not exist within the system.
2. **When** The user adds an item to an inventory and submits.
3. **Then** The system will throw an error stating to the user that the item is not in the system.

### Example 3

1. **Given** The employee does not exist within the system.
2. **When** The user adds an item to an inventory and submits.
3. **Then** The system will throw an error stating to the user that the employee is not in the system.
