# API Documentation

### Check Brackets

Endpoint for checking if brackets are correctly placed with text.

**URL**: `/api/checkBrackets`

**Method**: `POST`

**Request Body**:

{
"text": "String"
}

- text (required): The text to check for correct bracket placement.

Response:
{
"isCorrect": true,
"error": null
}

- isCorrect: A boolean value indicating if the brackets are correctly placed with text.

- error: An error message if an error occurs during the operation.

Error Responses
Response (400 Bad Request):

{
"isCorrect": false,
"error": "Error message"
}

- error: An error message describing the cause of the error.

Response (500 Internal Server Error):

{
"isCorrect": false,
"error": "Internal server error"
}

- error: An error message indicating an internal server error.