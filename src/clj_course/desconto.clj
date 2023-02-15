(ns clj-course.desconto)

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto
  for estritamente maior que 100."
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (println "Calculando com desconto de" desconto)
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado 100))
(println (valor-descontado 1000))

; Uma função que tem vários caminhos lógicos, tem alta complexidade de compreensão = complexidade ciclomática

; Predicados - PREDICATE (true or false)
; predicate é uma função que retorna true ou false
(defn aplica-desconto?
  "Recebe um valor bruto e verifica se é maior que 100"
  [valor-bruto]
  (if (> valor-bruto 100)
    true
    false))


(println (aplica-desconto? 100))
(println (aplica-desconto? 1000))


(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto
  for estritamente maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)                        ; incluiu a nova função
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (println "Calculando com desconto de" desconto)
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado 100))
(println (valor-descontado 1000))

; redefinir a função aplica-desconto?
(defn aplica-desconto?
  "Recebe um valor bruto e verifica se é maior que 100"
  [valor-bruto]
  (println "chamando a versao redefinida")
  (if (> valor-bruto 100)
    true))                                                  ; retirando o false retornará nil (null), mas precisamos lembra que o nulo = false


(println (aplica-desconto? 100))
(println (aplica-desconto? 1000))

; uso do when ao invés do if
(defn aplica-desconto?
  "Recebe um valor bruto e verifica se é maior que 100"
  [valor-bruto]
  (println "chamando a versao when")
  (when (> valor-bruto 100)                                 ; ele devolve somente o primeiro caso - somente verdadeiro (true)
    true))                                                  ; retirando o false retornará nil (null), mas precisamos lembra que o nulo = false


(println (aplica-desconto? 100))
(println (aplica-desconto? 1000))

; uso do when ao invés do if
(defn aplica-desconto?
  "Recebe um valor bruto e verifica se é maior que 100"
  [valor-bruto]
  (println "chamando a versao direta")
  (> valor-bruto 100))


(println (aplica-desconto? 100))
(println (aplica-desconto? 1000))

; funções como parâmetros

(defn mais-caro-que-100?
  "Recebe um valor bruto e verifica se é maior que 100"
  [valor-bruto]
  (println "deixando claro invocação de mais-caro-que-100?")
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se deve aplicar desconto."
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (println "Calculando com desconto de" desconto)
      (- valor-bruto desconto))
    valor-bruto))
(println "função como parâmetro")
(println (valor-descontado mais-caro-que-100? 100))
(println (valor-descontado mais-caro-que-100? 1000))


; (>*.*)> HIGHER ORDER FUNCTIONS <(*.*<)
; IMUTABILIDADE

(println "função sem nome - Função anônima")
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 100))
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 1000))
(println (valor-descontado (fn [v] (> v 100)) 1000)) ; o uso de abreviação dos símbolos
(println (valor-descontado (fn [v] (> v 100)) 100))
(println (valor-descontado #(> % 100) 1000)) ; com o # podemos abreviar o fn
(println (valor-descontado #(> %1 100) 100)) ; lambda

(def mais-caro-que-100? (fn [valor-bruto] (> valor-bruto 100))) ; define esse símbolo como esta função.
(def mais-caro-que-100? #(> % 100)) ; lambda

(defn f
  "Faz nada" ; aqui fica o comentario (opcional)
  [x y] ; aqui ficam os parametros da funcao
  (* x y))

(fn [x y]
  (* x y)) ; syntax sugar

#(* %1 %2)