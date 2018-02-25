# eMoflon::IBeX UI
Editors for Graph Transformation (GT) Rules and Triple Graph Grammars (TGGs)
	used in [eMoflon::IBeX](https://github.com/eMoflon/emoflon-ibex)

## Documentation for Developers
The [Xtext tutorial](https://www.eclipse.org/Xtext/documentation/102_domainmodelwalkthrough.html)
	explains the usage of the different projects.

### How to develop
1. Install [eMoflon::IBeX Democles](https://github.com/eMoflon/emoflon-ibex-democles).
2. Clone this repository.
3. Import the projects into your Eclipse development workspace:
    *File* - *Import*, select *Git* - *Projects from Git*.
    You may choose to group the projects into a new working set.
4. Generate code via *Run As* - *Generate Xtext Artefacts* on the `*.xtext` files:
	- `*GT.xtext` in package `org.emoflon.ibex.gt.editor`
		in the source folder of the project of the same name
	- `*TGG.xtext` in package `org.moflon.tgg.mosl`
		in the source folder of the project `org.emoflon.ibex.tgg.editor`
5. All errors shown in the workspace before should be gone now
	and you're ready to start developing.

For manual testing you have to start an Eclipse instance out of your development workspace
	via *Run As* - *Eclipse Application*.

### How run JUnit tests
(for GT editor only)
1. Install [EclEmma](http://www.eclemma.org/installation.html).
2. Run the tests on the project `org.emoflon.ibex.gt.ui.editor.tests`
	via *Coverage As* - *JUnit Test*
	with the coverage configuration set to `org.emoflon.ibex.gt.editor - xtend-gen`.

If you are not interested in code coverage, you may run the tests via *Run As* - *JUnit Test*.
