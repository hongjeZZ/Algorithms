-- 코드를 입력하세요
SELECT
    F.FLAVOR
FROM
    FIRST_HALF as F
JOIN
    ICECREAM_INFO as I
ON
    I.FLAVOR = F.FLAVOR
WHERE
    F.TOTAL_ORDER > 3000 AND
    I.INGREDIENT_TYPE = 'fruit_based'
ORDER BY
    F.TOTAL_ORDER DESC;
