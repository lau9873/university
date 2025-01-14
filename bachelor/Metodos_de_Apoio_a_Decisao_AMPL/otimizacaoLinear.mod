set prato;
set vit;

param preco {prato};
param min_semanal;
param percentagens {prato,vit};

var quantidades {p in prato} >= 0;

minimize custos: sum {p in prato} preco[p]*quantidades[p];

a {i in vit}: sum {p in prato} percentagens[p,i] * quantidades[p] >= min_semanal;