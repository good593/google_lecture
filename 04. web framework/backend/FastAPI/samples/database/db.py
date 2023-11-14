import pymysql 
import contextlib


@contextlib.contextmanager
def __get_cur():
    con = pymysql.connect(host='localhost', user='urstory', password='u1234',
                        db='examplesdb', charset='utf8') # 한글처리 (charset = 'utf8')
    cur = con.cursor(pymysql.cursors.DictCursor)
    try:
        yield cur
    finally:
        con.commit()
        cur.close()
        con.close()

def select_datas(sql, params=None):

    with __get_cur() as cur:
        if params:
            cur.execute(sql, params)
            
        else:
            cur.execute(sql)

    results = cur.fetchall()
    return results

def update_data(sql, params=None):

    with __get_cur() as cur:
        if params:
            cur.execute(sql, params)
            
        else:
            cur.execute(sql)

def insert_data(sql, params=None):

    with __get_cur() as cur:
        if isinstance(params, list) and isinstance(params[0], list) and len(params) > 0:
            cur.executemany(sql, params)

        else:
            cur.execute(sql, params)


