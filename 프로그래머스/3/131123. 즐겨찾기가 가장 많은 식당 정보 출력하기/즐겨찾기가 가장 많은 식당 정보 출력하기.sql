SELECT
    A.FOOD_TYPE, A.REST_ID, A.REST_NAME, A.FAVORITES 
FROM
    REST_INFO AS A
INNER JOIN 
    (SELECT 
        FOOD_TYPE, MAX(FAVORITES) AS FAVORITES
     FROM 
        REST_INFO
     GROUP BY 
        FOOD_TYPE) AS B
ON 
    A.FOOD_TYPE = B.FOOD_TYPE AND 
    A.FAVORITES = B.FAVORITES
ORDER BY 1 DESC;