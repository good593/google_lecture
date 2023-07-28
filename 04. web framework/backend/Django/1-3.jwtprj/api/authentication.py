import jwt, datetime 
from rest_framework.exceptions import AuthenticationFailed

RANDOM_OF_ACCESS_KEY = "access_secret" # #'랜덤한 조합의 키'
RANDOM_OF_REFRESH_KEY = "refresh_secret" # #'랜덤한 조합의 키'

def create_access_token(id):
    return jwt.encode({
        'user_id': id,
        'exp': datetime.datetime.now() + datetime.timedelta(seconds=120), # expired date
        'iat': datetime.datetime.now() # created date 
    }, RANDOM_OF_ACCESS_KEY, algorithm='HS256')

def decode_access_token(token):
    try:
        payload = jwt.decode(token, RANDOM_OF_ACCESS_KEY, algorithms='HS256')

        return payload['user_id']
    except Exception as e:
        raise AuthenticationFailed(e)

def create_refresh_token(id):
    return jwt.encode({
        'user_id': id,
        'exp': datetime.datetime.now() + datetime.timedelta(days=7), # expired date
        'iat': datetime.datetime.now() # created date 
    }, RANDOM_OF_REFRESH_KEY, algorithm='HS256')

def decode_refresh_token(token):
    try:
        payload = jwt.decode(token, RANDOM_OF_REFRESH_KEY, algorithms='HS256')

        return payload['user_id']
    except Exception as e:
        raise AuthenticationFailed(e)

