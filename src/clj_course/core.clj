(ns clj-course.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


; Define simbolo
(println "Bem vindo")
(def total-de-produtos 15)

(println total-de-produtos)
(println "Total" total-de-produtos)
(+ 13 3)
(> 1 3)
(< 1 3)

(or (< 1 3) (> 5 6))

; vetor
(def estoque ["Mochila" "Camisa"])
; como acessa o primeiro elemento
(estoque 0)

(["pablo" "kate" "boris"] 2)

(str/join " " ["eu" "comi" "lasanha"])
; incluir mais um elemento no estoque - obs (imutável)
(conj estoque "Cadeira")

(def estoque (conj estoque "Cadeira "))

; função e parâmetros

(defn imprime-mensagem
  []
  (println "------------")
  (println "Bem vindo(a) ao estoque!!"))

(imprime-mensagem)

(defn valor-descontado
  "Retorna o valor com desconto de 10% no valor bruto"
  [valor-bruto]
  (* valor-bruto (- 1 0.1)))

(valor-descontado 50)

; Verbo é efeito colateral ("realizar", ir fora do programa)
; Substantivo código puro (me devolve esse valor)


