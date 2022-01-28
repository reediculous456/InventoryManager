# Requirement 1: Create an Item

## Scenario

As a user, I want to be able to create an item so I can access it from anywhere within the system.

## Dependencies

The item that is being created is not in the system already.

## Examples

### Example 1

1. **Given** The item is not in the system.
2. **When** The item is being created by a user.
3. **When** The user attempts to save the item.
4. **Then** The item is saved and stored within the system.

### Example 2

1. **Given** The item is already in the system.
2. **When** The item is being created by a user.
3. **When** The user attempts to save the item.
4. **Then** The system will throw an error stating that the item is already in the system.

### Example 3

1. **Given** The item is not in the system
2. **When** The item is being created by a user.
3. **When** The user does not enter the required information.
4. **When** The user attempts to save the item.
5. **Then** The system will throw an error saying that the user has not entered the required information and needs to enter the data to be able to save the item.
