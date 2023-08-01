import jwt 
import datetime 

from rest_framework.exceptions import AuthenticationFailed

import enum 


class JWT_KEY(enum.Enum):
    RANDOM_OF_ACCESS_KEY = (enum.auto(), 'access_secret', datetime.timedelta(seconds=120), 'HS256', '랜덤한 조합의 키')
    RANDOM_OF_REFRESH_KEY = (enum.auto(), 'refresh_secret', datetime.timedelta(days=2), 'HS256', '랜덤한 조합의 키')


# https://pyjwt.readthedocs.io/en/stable/usage.html?highlight=iat#registered-claim-names
def __create_token(id:int, key:JWT_KEY) -> str:
    payload = {
        'user_id':id,
        # 아래에 있는 key 수정하시면 X
        'exp': datetime.datetime.now(tz=datetime.timezone.utc) + key.value[2],
        'iat': datetime.datetime.now(tz=datetime.timezone.utc) # create datetime 
    }
    random_key = key.value[1]
    alg = key.value[3]
    
    return jwt.encode(
        payload, random_key, algorithm=alg
    )

# create access token
def create_access_token(id):
    return __create_token(id, JWT_KEY.RANDOM_OF_ACCESS_KEY)

# create refresh token
def create_refresh_token(id):
    return __create_token(id, JWT_KEY.RANDOM_OF_REFRESH_KEY)


def __decode_token(token, key):
    try:
        alg = key.value[3]
        random_key = key.value[1]
        payload = jwt.decode(token, random_key, algorithms=alg)
        return payload['user_id']
    except Exception as e:
        raise AuthenticationFailed(e)

# decode access token 
def decode_access_token(token):
    return __decode_token(token, JWT_KEY.RANDOM_OF_ACCESS_KEY)


# decode refresh token
def decode_refresh_token(token):
    return __decode_token(token, JWT_KEY.RANDOM_OF_REFRESH_KEY)

