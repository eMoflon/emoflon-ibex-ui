# eMoflon::IBeX UI
Editors for Graph Transformation (GT) Rules and Triple Graph Grammars (TGGs)
	used in [eMoflon::IBeX](https://github.com/eMoflon/emoflon-ibex)

## Documentation for Developers
The [Xtext tutorial](https://www.eclipse.org/Xtext/documentation/102_domainmodelwalkthrough.html)
	explains the usage of the different projects.

## How to develop
1. Install [GraphViz](http://www.graphviz.org/download/).
2. Get the latest version of the [Eclipse Modeling Tools](https://www.eclipse.org/downloads/packages/).
3. Install Xtext from this update site (or use the Eclipse Marketplace):
	http://download.eclipse.org/modeling/tmf/xtext/updates/composite/releases/
4. Install PlantUML from this update site (or use the Eclipse Marketplace):
	http://hallvard.github.io/plantuml/
5. Check the encoding for Xtend files.
    - In Eclipse: Go to ```Window->Preferences->General->Workspace```.
    - Change the text file encoding to 'Other: UTF-8'.
6. Go to ```File/Import.../Team/Team Project Set```, check URL and enter in and import one of these PSF files:<br/>
   For eMoflon including everything:	<br/>
	- https://raw.githubusercontent.com/eMoflon/emoflon-ibex-deployment/master/devProjectSet.psf <br/>
7. Execute MWE2
    - Open packages ```org.emoflon.ibex.gt.editor/src/org.emoflon.ibex.gt.editor``` and ```org.emoflon.ibex.tgg.editor/src/org.moflon.tgg.mosl```
    - Right-click on ```GenerateGT.mwe2``` in the first package and ```GenerateTGG.mwe2``` in the second.
    - Press ```Run As -> MWE2 Workflow```.
8. Set UTF-8 as file encoding for the development workspace (*Window &rarr; Preferences &rarr; General/Workspace*) and build all projects (*Project &rarr; Build All*) to trigger code generation (and get rid of errors).
9. Set up your runtime and test workspaces by starting a runtime Eclipse workspace
	from your development workspace, and importing this PSF file:<br/>
	https://raw.githubusercontent.com/eMoflon/emoflon-ibex-tests/master/testProjectSet.psf
10. Inside the runtime workspace, build all projects (*Project &rarr; Build All*) to trigger code generation.
11. Run the JUnit tests to ensure that all is well by right-clicking
	one of the ```Testsuite_*.launch``` in the ```Testsuite``` project
	and ```TestsuiteGT.launch``` in the ```TestsuiteGT``` project
	and start the tests by selecting ```Run As/JUnit```.
	If everything is set up correctly, all tests should be green.

Running ```Testsuite_GLPK.launch``` requires GLPK (see installation step 5).
	
Running ```Testsuite_Gurobi.launch``` requires Gurobi (see installation step 6).

Running ```Testsuite_CBC.launch``` requires Google OR tools (see installation step 7).

```Testsuite_SAT4J.launch``` uses the SAT4J (automatically installed, but the slowest option). 

### How run JUnit tests
(for GT editor only)
1. Install [EclEmma](http://www.eclemma.org/installation.html).
2. Run `EditorTests.launch` in the project `org.emoflon.ibex.gt.editor.tests` via *Coverage As*.

If you are not interested in code coverage, you may run the tests via *Run As*.
