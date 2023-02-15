(ns clj-course.core ; namespace
  (:gen-class)
  (:require [clojure.string :as str]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(comment
  ; Define símbolo
  (println "Bem vindo")
  (def total-de-produtos 15)

  (println total-de-produtos)
  (println "Total" total-de-produtos)

  ; operacoes matematicas
  (+ 13 3)
  (> 1 3)
  (< 1 3)
  (or (< 1 3) (> 5 6))

  )


; vetor
(def estoque ["Mochila" "Camisa"])
; como acessa o primeiro elemento
(estoque 0)

(["pablo" "kate" "boris"] 2)
 (str/join " " ["eu" "comi" "lasanha"])
; incluir mais um elemento no estoque - obs (imutável)
; (conj estoque "Cadeira")
; (def estoque (conj estoque "Cadeira "))

; função e parâmetros

(defn imprime-mensagem
  []
  (println "------------")
  (println "Bem vindo(a) ao estoque!!"))

(comment (imprime-mensagem))

(defn valor-descontado
  "Retorna o valor com desconto de 10% no valor bruto"
  [valor-bruto]
  (* valor-bruto (- 1 0.10)))

(valor-descontado 50)

; Verbo é efeito colateral ("realizar", ir fora do programa)
; Substantivo código puro (me devolve esse valor)


; redefinindo a função
(defn valor-com-desconto
  "Retorna o valor com desconto de 10% no valor bruto"
  [valor-bruto]
  (let [taxa-de-desconto (/ 10 100)
        desconto         (* valor-bruto taxa-de-desconto)]
    (println "Calculando com desconto de" desconto)
    (- valor-bruto desconto)))
  ; definir um símbolo local, podemos usar o let = escopo local
  ; 'dentro do parenteses' (recebe um vetor).
  ; let pode receber várias definições

(valor-com-desconto 100)

(comment
  ; Cmd + Shift + P => executa código no repl
  ; Cmd + Shift + L => executa o código inteiro
  ; (1 2 3 4) Cmd + Shift + K => engole para o parênteses
  ; (1 2 3 4) Cmd + Shift + J => expulsa para o parênteses
  )

; condições

(if (< 500 100)
  (println "maior")
  (println "menor ou igual")) ; else

; nossa função com definição de condição

(defn valor-com-desconto
  "Retorna o valor com desconto de 10% se o valor bruto
  for estritamente maior que 100."
  [valor-bruto]
  (if (> valor-bruto 100)
  (let [taxa-de-desconto (/ 10 100)
        desconto         (* valor-bruto taxa-de-desconto)]
    (println "Calculando com desconto de" desconto)
    (- valor-bruto desconto))
  valor-bruto))
; nil(Nulo) é considerado false dentro do if

(valor-com-desconto 100)

