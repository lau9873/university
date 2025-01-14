horasMinutos :: Int -> Int -> Int
horasMinutos a b = a*60 + b
diferencaMinutos :: Int -> Int -> Int -> Int -> Int
diferencaMinutos a b c d = horasMinutos c d - horasMinutos a b
dialogo :: Int -> Int -> Int -> Int -> (String, String)
dialogo h1 m1 h2 m2 
    | difMin == 1 = ("Passou apenas 1 minuto!","Queres dizer, 60 segundos?!")
    | difMin < 60 = ("Passaram apenas " ++ show difMin ++ " minutos!", "Queres dizer, " ++ show (difMin*60) ++ " segundos?!")
    | difMin == 61 = ("Passaram apenas " ++ show difMin ++ " minutos!", "Queres dizer, 1 hora e 1 minuto?!")
    | difMin == 60 = ("Passaram apenas 60 minutos!","Queres dizer, 1 hora?!")
    | div difMin 60 == 1 = ("Passaram apenas " ++ show difMin ++ " minutos!","Queres dizer, 1 hora e " ++ show (mod difMin 60) ++ " minutos?!")
    | mod difMin 60 == 0 = ("Passaram apenas " ++ show difMin ++ " minutos!", "Queres dizer, " ++ show (div difMin 60) ++ " horas?!")
    | mod difMin 60 == 1 = ("Passaram apenas " ++ show difMin ++ " minutos!", "Queres dizer, " ++ show (div difMin 60) ++ " horas e 1 minuto?!")
    | otherwise = ("Passaram apenas " ++ show difMin ++ " minutos!", "Queres dizer, " ++ show (div difMin 60) ++ " horas e " ++ show (mod difMin 60) ++ " minutos?!")
    where difMin = diferencaMinutos h1 m1 h2 m2