# Train Reservation System

## Overview
This project is a Train Reservation System that allows users to check train details and make seat reservations. The system tracks train coaches and their capacity, allowing reservations based on seat availability. The reservation can be made across different coaches if allowed.

## Entities

### Train
The `Train` entity represents a train in the system with the following fields:
- `id`: Unique identifier for the train.
- `name`: Name of the train.

### Coach
The `Coach` entity represents a coach attached to a train. It includes:
- `id`: Unique identifier for the coach.
- `train`: Associated train (`@ManyToOne` relationship).
- `name`: Name of the coach.
- `capacity`: Total seat capacity of the coach.
- `occupiedSeats`: Number of currently occupied seats.

## Data Transfer Objects (DTOs)

### AllocationDetail
Used to represent seat allocation details during a reservation.
- `coachName`: Name of the coach where the seats are allocated.
- `numberOfPeople`: Number of people allocated to this coach.

### CoachDetail
Represents detailed information about a coach.
- `name`: Name of the coach.
- `capacity`: Total seat capacity.
- `occupiedSeats`: Number of currently occupied seats.

### CoachRequest
Used to make requests for coach details during reservation.
- `name`: Name of the coach.
- `capacity`: Total seat capacity.
- `occupiedSeats`: Number of currently occupied seats.

### ReservationRequest
Represents a reservation request made by the user.
- `trainName`: Name of the train to reserve seats on.
- `coaches`: List of coaches involved in the reservation.
- `numberOfPeople`: Number of people to reserve seats for.
- `canAllocateToDifferentCoaches`: Boolean indicating if people can be split across different coaches.

### ReservationResponse
Response object for the reservation request.
- `reservationPossible`: Boolean indicating whether the reservation is possible.
- `allocationDetails`: List of `AllocationDetail` showing where people have been allocated.

### TrainDetail
Provides detailed information about a train, including its coaches.
- `name`: Name of the train.
- `coaches`: List of `CoachDetail` objects.

### TrainResponse
Response object for train details.
- `train`: Detailed information about the train.

## Controllers

### ReservationController
Handles API requests for making reservations.
- `POST /api/reservations`: Accepts a reservation request and returns whether the reservation was successful and the allocation details.
  - **Request**: `ReservationRequest`
  - **Response**: `ReservationResponse`
  - In case of an error, a `400 Bad Request` response is returned.

### TrainController
Handles API requests for retrieving train details.
- `GET /api/trains/{trainName}`: Fetches detailed information about a train by name.
  - **Path Parameter**: `trainName` - The name of the train.
  - **Response**: `TrainResponse`
  - Returns `404 Not Found` if the train does not exist.

## Services

### ReservationService
Handles business logic related to train reservations.
- **Method**: `processReservation(ReservationRequest request)`
  - Validates the request and checks the availability of seats in the coaches.
  - Allocates seats to passengers based on coach availability and seat occupancy (coaches cannot be more than 70% full).
  - If the reservation is successful, the `ReservationResponse` is returned with the allocation details; otherwise, a failed response is returned.

## How It Works

1. **Train Information**: The system stores information about trains and their coaches, including the seat capacity and occupied seats for each coach.
2. **Seat Reservation**: Users can make a reservation by specifying the number of people and the train name. The system will check the availability of seats and assign them based on coach capacity and existing occupancy.
3. **Coach Allocation**: The system ensures that coaches do not exceed 70% occupancy, and if seats are available, it allocates them accordingly.
4. **Reservation Response**: The user receives a response detailing whether the reservation was successful and which coaches were assigned.

## Technologies Used
- **Java Spring Boot**: Backend framework.
- **JPA/Hibernate**: ORM for database interaction.
- **REST API**: Used for handling train and reservation operations.

## Running the Project
1. Clone the repository.
2. Configure the database in `application.properties`.
3. Run the project using Spring Boot.
4. Access the API endpoints via Postman or another API client.

