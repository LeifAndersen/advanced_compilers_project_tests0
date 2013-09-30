all: run

run:
	sbt run

test:
	sbt test:run

answers:
	for i in tests/*.rkt; \
	do if [ ! -f $$i.expected ]; then \
	printf "%s\n" "Compiling $$i"; \
	racket compile.rkt < $$i > $$i.expected; \
	fi done
