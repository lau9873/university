# Definir as variáveis
var c >= 0;
var t >= 0;
var q >= 0;
var e >= 0;

# Definir as restrições com nomes simbólicos
subject to R1: c + q + t = 19;
subject to R2: 2*e + t = 14;
subject to R3: 2*c + e = 15;
subject to R4: 2*q + e = 13;
subject to R5: e + 2*t = 19;

# Sem função objetivo, apenas resolver o sistema
solve;

# Exibir os resultados
display c, t, q, e;
