from rest_framework.views import exception_handler 

def status_code_handler(exc, context):
    response = exception_handler(exc, context)

    if response is not None:
        response.status_code = 777
    elif response.status_code >= 400 and response.status_code < 500:
        response.status_code = 444
    elif response.status_code >= 500:
        response.status_code = 555
    
    return response