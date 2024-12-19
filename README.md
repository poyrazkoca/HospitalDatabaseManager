# Hospital Database Manager

The project utilizes binary search trees (BST) for efficient organization and retrieval of data. This implementation strictly avoids the use of external libraries and is built entirely using custom Java code.

## Features

The system provides the following functionalities:

1. **Add a Patient**
   - Registers a new patient, including their name, visit date, and doctor's information.
   - If a patient with the same name already exists, their information is updated.

2. **Remove a Patient**
   - Deletes a patient record from the database.
   - Displays a warning if the patient does not exist.

3. **Add a Medical Staff Member to a Care Team**
   - Adds a medical staff member to the care team of a specific patient.
   - Updates existing information if the staff member is already in the team.

4. **Remove a Medical Staff Member from a Care Team**
   - Removes a staff member from a patient's care team.
   - Ensures the care team remains sorted in ascending order.

5. **Show the List of Patients**
   - Displays all patients in the database, sorted by their visit year in ascending order.

6. **Show Detailed Information About a Patient**
   - Provides comprehensive details about a specific patient, including their care team sorted alphabetically.

7. **Query Patients Seen by a Specific Doctor**
   - Lists all patients treated by a specified doctor, sorted by visit year in descending order.

8. **Query Patients Who Visited in a Given Year**
   - Lists all patients who visited the hospital in a specific year, sorted by visit date.

## Project Structure

- **Binary Search Trees**: 
  - Patients are stored in a BST based on their visit year.
  - Each patient's care team is stored in a separate BST sorted by staff names.

- **Classes**:
  - `HospitalDatabase`: Main class with public member functions to handle database operations.
  - Additional helper classes to manage patients, doctors, care teams, and BST nodes.

## Setup and Usage

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repo/hospital-database-manager.git
   cd hospital-database-manager
