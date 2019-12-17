SHELL = bash
MAIN ?= main
MAINCL = $(shell MAINKT=${MAIN}; echo $${MAINKT^})

# $(error ${MAIN})

.PHONY: check clean

# kotlinc -jda-home <path> -kotlin-home <path> -include-runtime

prog: check
	kotlinc-jvm $(MAIN).kt

run: check
	@java -cp "${KOTLIN_JARS_WIN}" tut1/$(MAINCL)Kt

clean:
	rm -rf tut1 META-INF

check:
ifndef KOTLIN_JARS_WIN
	$(error "KOTLIN_JARS_WIN not defined ... run kotlin_jars_win")
else
	@echo "KOTLIN_JARS_WIN ... OK"
endif

