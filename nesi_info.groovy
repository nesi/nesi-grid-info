import grisu.jcommons.model.info.*


// variables

// the numbers of the merit groups that have access to the auckland cluster
akl_project_groups = [2,11,12,13,28,30,31,35,39,99999]
uoc_project_groups = [12,31]

// sites
auckland = new Site(
		name = 'Auckland'
		)

canterbury = new Site(
		name = 'Canterbury'
		)

landcare = new Site(
		name = 'Landcare'
		)

// vos
nz = new VO(
		voName = 'nz',
		host = 'voms.bestgrid.org',
		port = 15000,
		hostDN = '/C=TW/O=AP/OU=GRID/CN=voms.bestgrid.org'
		)


// groups
bestgrid = new Group(
		vo = nz,
		fqan = '/nz/bestgrid'
		)

bluefern = new Group(
		vo = nz,
		fqan = '/nz/bluefern'
		)


grid_dev = new Group(
		vo = nz,
		fqan = "/nz/grid-dev"
		)

landcare_users = new Group(
		vo = nz,
		fqan = "/nz/landcare"
		)

landcare_admin = new Group(
		vo = nz,
		fqan = "/nz/landcare/admin"
		)

landcare_osgeo = new Group(
		vo = nz,
		fqan = "/nz/landcare/osgeo"
		)


nesi = new Group(
		vo = nz,
		fqan = "/nz/nesi"
		)


def nesi_akl_groups = []
akl_project_groups.each {
	nesi_akl_groups.add(new Group(vo = nz, fqan = "/nz/nesi/projects/nesi"+String.format("%05d", it)))
}
def nesi_uoc_groups = []
uoc_project_groups.each {
	nesi_uoc_groups.add(new Group(vo = nz, fqan = "/nz/nesi/projects/nesi"+String.format("%05d", it)))
}

nesi_uoc_groups.add(new Group(vo = nz, fqan = "/nz/nesi/projects/test99999"))




uoa = new Group(
		vo = nz,
		fqan = '/nz/uoa'
		)

uoa_civil_eng = new Group(
		vo = nz,
		fqan = '/nz/civil_engineering'
		)

uoa_comp_chem = new Group(
		vo = nz,
		fqan = '/nz/uoa/comp-chem'
		)

uoa_gaussian = new Group(
		vo = nz,
		fqan = '/nz/uoa/comp-chem/gaussian'
		)

uoa_vasp = new Group(
		vo = nz,
		fqan = '/nz/uoa/comp-chem/vasp')

uoa_comp_evol = new Group(
		vo = nz,
		fqan = '/nz/uoa/comp-evol'
		)

uoa_comp_sci = new Group(
		vo = nz,
		fqan = '/nz/uoa/comp-sci'
		)

uoa_comp_sci_research = new Group(
		vo = nz,
		fqan = '/nz/uoa/comp-sci/research'
		)

uoa_eng_sci = new Group(
		vo = nz,
		fqan = '/nz/uoa/engineering-science'
		)

uoa_epigen = new Group(
		vo = nz,
		fqan = '/nz/epigen'
		)

uoa_math = new Group(
		vo = nz,
		fqan = '/nz/uoa/math'
		)

uoa_mech_eng = new Group(
		vo = nz,
		fqan = '/nz/uoa/mechanical-engineering'
		)

uoa_mnl = new Group(
		vo = nz,
		fqan = '/nz/uoa/mnl'
		)

uoa_qualitas = new Group(
		vo = nz,
		fqan = '/nz/uoa/qualitas'
		)

uoa_qoptics = new Group(
		vo = nz,
		fqan = '/nz/uoa/quantum-optics'
		)

uoa_stats = new Group(
		vo = nz,
		fqan = '/nz/uoa/stats'
		)

uoa_stats_staff = new Group(
		vo = nz,
		fqan = '/nz/uoa/stats/staff'
		)

uoa_stats_students = new Group(
		vo = nz,
		fqan = '/nz/uoa/stats/students'
		)

uoa_wtccc = new Group(
		vo = nz,
		fqan = '/nz/uoa/stats/wtccc'
		)

uoa_virt_screening = new Group(
		vo = nz,
		fqan = '/nz/virtual-screening'
		)

uoa_acsrc = new Group(
		vo = nz,
		fqan = '/nz/virtual-screening/acsrc'
		)

uoa_vs_jobs = new Group(
		vo = nz,
		fqan = '/nz/virtual-screening/jobs'
		)

uoa_sbs = new Group(
		vo = nz,
		fqan = '/nz/virtual-screening/sbs-structural-biology'
		)

uoo = new Group(
		vo = nz,
		fqan = '/nz/uoo'
		)



// filesystems
auckland_df_fs = new FileSystem(
		host:'df.auckland.ac.nz',
		site:auckland
		)

auckland_pan_fs = new FileSystem(
		host:'pan.nesi.org.nz',
		site:auckland,
		available:true
		)

canterbury_ng1_fs = new FileSystem(
		host:'ng1.canterbury.ac.nz',
		site:canterbury
		)

canterbury_ng2_fs = new FileSystem(
		host:'ng2.canterbury.ac.nz',
		site:canterbury
		)

canterbury_ng2hpc_fs = new FileSystem(
		host:'ng2hpc.canterbury.ac.nz',
		site:canterbury
		)

canterbury_ng2sge_fs = new FileSystem(
		host:'ng2sge.canterbury.ac.nz',
		site:canterbury
		)

canterbury_gram5bgp_fs = new FileSystem(
		host:'gram5bgp.canterbury.ac.nz',
		site:canterbury
		)

canterbury_gram5p7_fs = new FileSystem(
		host:'gram5p7.canterbury.ac.nz',
		site:canterbury
		)

//scenzgrid_fs = new FileSystem(
//		host:'ng2.scenzgrid.org',
//		site:landcare
//		)

// directories (make sure to always have a trailing slash for the path element
auckland_cluster_groups = [
	grid_dev,
	nesi,
	uoa,
	uoa_comp_chem,
	uoa_gaussian,
	uoa_comp_evol,
	uoa_eng_sci,
	uoa_math,
	uoa_mech_eng,
	uoa_qoptics,
	uoa_stats,
	uoa_stats_staff,
	uoa_stats_students
	//	uoa_vs_jobs,
	//	uoa_sbs,
	//	uoa_acsrc,
	//	uoa_virt_screening
] + nesi_akl_groups


auckland_pan = new Directory(
	filesystem:auckland_pan_fs,
	groups:auckland_cluster_groups,
	alias:"pan",
	options:[volatileDirectory:true, globusOnline:true],
	available:true
	)

auckland_gpfs1m = new Directory(
	filesystem:auckland_pan_fs,
	groups:auckland_cluster_groups,
	path:"/gpfs1m",
	alias:"gpfs1m",
	options:[volatileDirectory:false, globusOnline:true],
	available:true
	)

auckland_df_home = new Directory(
		filesystem:auckland_df_fs,
		groups:[nesi],
		path:"/~/",
		alias:"datafabric",
		options:[volatileDirectory:false, globusOnline:true]
		)

auckland_vs_group = new Directory(
		filesystem:auckland_pan_fs,
		groups:[uoa_virt_screening],
		path:"/home/grid-vs/",
		alias:"virtual_screening",
		options:[volatileDirectory:false, globusOnline:true, shared:false],
		available:true
		)

auckland_acsrc_group = new Directory(
		filesystem:auckland_pan_fs,
		groups:[uoa_acsrc],
		alias:"vs-acsrc",
		options:[volatileDirectory:false, globusOnline:true],
		path:"/home/grid-acsrc/",
		available:true
		)

auckland_sbs_group = new Directory(
		filesystem:auckland_pan_fs,
		groups:[uoa_sbs],
		options:[volatileDirectory:false, globusOnline:true],
		alias:"vs-sbs",
		path:"/home/grid-sbs/",
		available:true
		)

canterbury_ng1_home = new Directory(
		filesystem:canterbury_ng1_fs,
		groups:[bestgrid],
		path:"/~/",
		alias:"blufern-ng1",
		options:[volatileDirectory:true, globusOnline:true],
		available:true
		)

canterbury_ng2_home = new Directory(
		filesystem:canterbury_ng2_fs,
		groups:[bestgrid],
		path:"/~/",
		alias:"bluefern-ng2",
		options:[volatileDirectory:true, globusOnline:true],
		available:true
		)

canterbury_ng2hpc_home = new Directory(
		filesystem:canterbury_ng2hpc_fs,
		groups:[bestgrid, bluefern],
		path:"/~/",
		options:[volatileDirectory:true, globusOnline:true],
		available:true
		)

canterbury_gram5p7_home = new Directory(
		filesystem:canterbury_gram5p7_fs,
		groups:[nesi, bestgrid, bluefern] + nesi_uoc_groups,
		path:"/~/",
		alias:"bluefern-p7",
		options:[volatileDirectory:true, globusOnline:true],
		available:true
		)

canterbury_ng2sge_home = new Directory(
		filesystem:canterbury_ng2sge_fs,
		groups:[bestgrid],
		path:"/~/",
		alias:"bluefern-sge",
		options:[volatileDirectory:true, globusOnline:true],
		available:true
		)

canterbury_gram5bgp_home = new Directory(
		filesystem:canterbury_gram5bgp_fs,
		groups:[nesi, bluefern],
		path:"/~/",
		alias:"bluefern-bgp",
		options:[volatileDirectory:true, globusOnline:true],
		available:true
		)

//scenzgrid_home = new Directory(
//		filesystem:scenzgrid_fs,
//		groups:[bestgrid,landcare_users],
//		options:[volatileDirectory:true, globusOnline:true],
//		path:'/~/'
//		)

globus4 = Middleware.get("Globus", "4.0.0")
globus5 = Middleware.get("Globus", "5.0")


// gateways
pan = new Gateway(
		site:auckland,
		host:"pan.nesi.org.nz",
		middleware:globus5
		)


canterbury_ng2 = new Gateway(
		site:canterbury,
		host:"ng2.canterbury.ac.nz",
		middleware:globus4
		)

canterbury_ng1 = new Gateway(
		site:canterbury,
		host:"ng1.canterbury.ac.nz",
		middleware:globus5
		)

canterbury_ng2hpc = new Gateway(
		site:canterbury,
		host:"ng2hpc.canterbury.ac.nz",
		middleware:globus4
		)

canterbury_ng2sge = new Gateway(
		site:canterbury,
		host:"ng2sge.canterbury.ac.nz",
		middleware:globus4
		)

canterbury_gram5p7 = new Gateway(
		site:canterbury,
		host:"gram5p7.canterbury.ac.nz",
		middleware:globus5
		)

canterbury_gram5bgp = new Gateway(
		site:canterbury,
		host:"gram5bgp.canterbury.ac.nz",
		middleware:globus5
		)

//landcare_gram4 = new Gateway(
//		site:landcare,
//		host:"ng2.scenzgrid.org",
//		middleware:globus4
//		)



// Applications

abaqus = Application.get('Abaqus')
beast = Application.get('BEAST')
best = Application.get('BEST')
bayesphylogenies = Application.get('BayesPhylogenies')
blast = Application.get('BLAST')
blastplus = Application.get('BLAST+')
blender = Application.get('Blender')
bowtie2 = Application.get('bowtie2')
cegma = Application.get('cegma')
clustalw = Application.get('ClustalW')
clustalwparallel = Application.get('ClustalW Parallel')
gaussian = Application.get('Gaussian')
gcc = Application.get('gcc')
gold = Application.get('Gold')
gromacs = Application.get('GROMACS')
hagfish = Application.get('hagfish')
infernal = Application.get('infernal')
java = Application.get('Java')
lamarc = Application.get('LAMARC')
matlab = Application.get('matlab')
meme = Application.get('MEME')
modeltest = Application.get('ModelTest')
mono = Application.get('mono')
mothur = Application.get('mothur')
mrbayes = Application.get('MrBayes')
namd = Application.get('NAMD')
nomad = Application.get('nomad')
openbugs = Application.get('OpenBUGS')
paup = Application.get('PAUP*')
parswms = Application.get('PARSWMS')
qiime = Application.get('Qiime')
r = Application.get('R')
rmpisnow = Application.get('RMPISNOW')
unixcommands = Application.get('UnixCommands')
ilog = Application.get('ilog')
mpiblast = Application.get('mpiBLAST')
octave = Application.get('octave')
phyml = Application.get('phyml')
python = Application.get('python')
sas = Application.get('sas')
szybki = Application.get('szybki')
teiresias = Application.get('teiresias')
ultrabeast = Application.get('UltraBEAST')
wrf = Application.get('WRF')


// modules
module_python_2_7_virtualenv = Module.create('python/2.7_virtualenv')
module_python_2_6_virtualenv = Module.create('python/2.6_virtualenv')
module_cegma_2_4 = Module.create('cegma/2.4')
module_gaussian_b_01 = Module.create('Gaussian/B.01')
module_gaussian_c_01 = Module.create('Gaussian/C.01')
module_gaussian_d_01 = Module.create('Gaussian/D.01')
module_gromacs_4_5_4 = Module.create('gromacs/4.5.4')
module_gromacs_4_5_5 = Module.create('gromacs/4.5.5-gnu')
module_gromacs_4_5_5_opt = Module.create('gromacs/4.5.5_ics-2011_mkl_ompi-1.6.3-sandybridge')
module_gromacs_4_6 = Module.create('gromacs/4.6.1_ics-2011_mkl_ompi-1.6.0-sandybridge')
module_hagfish_2013_03_14 = Module.create('hagfish/2013_03_14')
//module_matlab_uoaabi = Module.create('matlab/matlab-uoaabi')
module_matlab_uoafoe = Module.create('MATLAB/UoA-FoE')
module_matlab_uoafos = Module.create('MATLAB/UoA-FoS')
//module_matlab_uoamath = Module.create('matlab/matlab-uoamath')
//module_matlab_uoo = Module.create('matlab/matlab-uoo')
module_mothur_1_6_0 = Module.create('mothur/1.6.0')
module_openbugs_3_2_2 = Module.create('OpenBUGS/3.2.2')
module_phyml_20120412 = Module.create('phyml/20120412')
module_phyml_20121208 = Module.create('phyml/20120412-patch-20121208')
module_qiime_1_4_0 = Module.create('qiime/1.4.0')
module_ultrabeast_0_1 = Module.create('UltraBEAST/0.1')
module_bowtie2_2_0_6 = Module.create('bowtie2/2.0.6')
module_sas_9_3 = Module.create('sas/9.3')
module_r_2_15_3 = Module.create('R/2.15.3')

// packages
abaqus_68ef2 = new Package(
		application:abaqus,
		version:Version.get('6.8-EF2'),
		executables:[Executable.get('abaqus')])

beast_1_6_1 = new Package(
		application: beast,
		version:Version.get('1.6.1'),
		executables:[Executable.get('beast')])

best_2_3_1 = new Package(
		application:best,
		version:Version.get('2.3.1')
		)

blast_2_2_21 = new Package(
		application:blast,
		version:Version.get('2.2.21')
		)

blast_2_2_26 = new Package(
		application:blast,
		version:Version.get('2.2.26')
		)

blastplus_2_2_27 = new Package(
		application:blastplus,
		module:Module.create('blast+/2.2.27'),
		version:Version.get('2.2.27')
		)

bayesphylogenies_1_0 = new Package(
		application:bayesphylogenies,
		version:Version.get('1.0')
		)

blender_2_49a = new Package(
		application:blender,
		version:Version.get('2.49a'),
		executables:[Executable.get('blender')])

bowtie2_2_0_6 = new Package(
		application:bowtie2,
		version:Version.get('2.0.6'),
		module:module_bowtie2_2_0_6,
		executables:[Executable.get('bowtie2')])

cegma_2_4 = new Package(
		application:cegma,
		version:Version.get('2.4'),
		module:module_cegma_2_4,
		executables:[Executable.get('cegma')])

clustalw_1_83 = new Package(
		application:clustalw,
		version:Version.get('1.83')
		)

clustalw_2_0_11 = new Package(
		application:clustalw,
		version:Version.get('2.0.11')
		)

clustalwparallel_0_13 = new Package(
		application:clustalwparallel,
		version:Version.get('0.13')
		)

gcc_4_7_2 = new Package(
		application:gcc,
		version:Version.get('4.7.2'),
		executables:[
			Executable.get('gcc')]
		)

gold_5_1 = new Package(
		application:gold,
		version:Version.get('5.1'),
		executables:[
			Executable.get('parallel_gold_auto')]
		)

gaussian_b_01 = new Package(
	application:gaussian,
	version:Version.get('B.01'),
	module:module_gaussian_b_01,
	executables:[
		Executable.get('g09')
	]
	)
gaussian_c_01 = new Package(
	application:gaussian,
	version:Version.get('C.01'),
	module:module_gaussian_c_01,
	executables:[
		Executable.get('g09')
	]
	)

gaussian_d_01 = new Package(
	application:gaussian,
	version:Version.get('D.01'),
	module:module_gaussian_d_01,
	executables:[
		Executable.get('g09')
	]
	)

gromacs_4_5_4 = new Package(
		application:gromacs,
		version:Version.get('4.5.4'),
		module:module_gromacs_4_5_4,
		executables:[
			Executable.get('mdrun'), Executable.get('mdrun_mpi'), Executable.get('grompp'), Executable.get('grompp_mpi')
		]
		)

gromacs_4_5_5 = new Package(
		application:gromacs,
		version:Version.get('4.5.5'),
		module:module_gromacs_4_5_5_opt,
		executables:[
			Executable.get('mdrun'), Executable.get('mdrun_mpi'), Executable.get('grompp'), Executable.get('grompp_mpi')
		]
		)

gromacs_4_6 = new Package(
		application:gromacs,
		version:Version.get('4.6'),
		module:module_gromacs_4_6,
		executables:[
			Executable.get('mdrun'), Executable.get('mdrun_mpi'), Executable.get('grompp'), Executable.get('grompp_mpi')
		]
		)
hagfish_2013_03_14 = new Package(
		application:hagfish,
		version:Version.get('2013_03_14'),
		module:module_hagfish_2013_03_14,
		executables:[
			Executable.get('hagfish_blockcompplot'),Executable.get('hagfish_blockcompplot2'),Executable.get('hagfish_blockplot'),Executable.get('hagfish_circos'),Executable.get('hagfish_compplot'),Executable.get('hagfish_compplot2')
		]
		)

ilog_12_2 = new Package(
		application:ilog,
		version:Version.get('12.2'),
		executables:[Executable.get('oplrun')])

infernal_1_0 = new Package(
		application:infernal,
		version:Version.get('1.0')
		)

java_1_6 = new Package(
		application:java,
		version:Version.get('1.6'),
		executables:Executable.getList('java', 'javac')
		)

lamarc_2_1 = new Package(
		application:lamarc,
		version:Version.get('2.1')
		)

//matlab_uoaabi = new Package(
//	application:matlab,
//	version:Version.get('uoaabi'),
//	module:module_matlab_uoaabi,
//	executables:Executable.getList('matlab', 'matlabcmd')
//	)
matlab_uoafoe = new Package(
	application:matlab,
	version:Version.get('uoafoe'),
	module:module_matlab_uoafoe,
	executables:Executable.getList('matlab', 'matlabcmd')
	)
matlab_uoafos = new Package(
	application:matlab,
	version:Version.get('uoafos'),
	module:module_matlab_uoafos,
	executables:Executable.getList('matlab', 'matlabcmd')
	)
//matlab_uoamath = new Package(
//	application:matlab,
//	version:Version.get('uoamath'),
//	module:module_matlab_uoamath,
//	executables:Executable.getList('matlab', 'matlabcmd')
//	)
//matlab_uoo = new Package(
//	application:matlab,
//	version:Version.get('uoo'),
//	module:module_matlab_uoo,
//	executables:Executable.getList('matlab', 'matlabcmd')
//	)


meme_4_1 = new Package(
		application:meme,
		version:Version.get('4.1.0')
		)

modeltest_3_7 = new Package(
		application:modeltest,
		version:Version.get('3.7')
		)

mono_2_6_7 = new Package(
		application:mono,
		version:Version.get('2.6.7')
		)

mothur_1_6_0 = new Package(
		application:mothur,
		version:Version.get('1.6.0')
		)

mpiblast_1_5 = new Package(
		application:mpiblast,
		version:Version.get('1.5.0'),
		executables:[Executable.get('mpiblast')])

mpiblast_1_6 = new Package(
		application:mpiblast,
		version:Version.get('1.6.0')
		)

mr_bayes_3_1_2 = new Package(
		application:mrbayes,
		version:Version.get('3.1.2'),
		module:Module.create('mrbayes/3.1.2'),
		executables:[Executable.get('mb')])

mr_bayes_3_2_1 = new Package(
		application:mrbayes,
		version:Version.get('3.2.1'),
		module:Module.create('mrbayes/3.2.1'),
		executables:[Executable.get('mb')])

mr_bayes_3_2_2 = new Package(
		application:mrbayes,
		version:Version.get('3.2.2'),
		module:Module.create('mrbayes/3.2.2'),
		executables:[Executable.get('mb')])

namd_2_6 = new Package(
		application:namd,
		version:Version.get('2.6')
		)

namd_2_7b1 = new Package(
		application:namd,
		version:Version.get('2.7b1')
		)

nomad_3_5_1 = new Package(
		application:nomad,
		version:Version.get('3.5.1')
		)

octave_3_0_3 = new Package(
		application:octave,
		version:Version.get('3.0.3'),
		executables:[Executable.get('octave')])

octave_3_0_5 = new Package(
		application:octave,
		version:Version.get('3.0.5'),
		executables:[Executable.get('octave')])

octave_3_4_2 = new Package(
		application:octave,
		version:Version.get('3.4.2'),
		executables:[Executable.get('octave')])

openbugs_3_2_2 = new Package(
		application:openbugs,
		version:Version.get('3.2.2'),
		module:module_openbugs_3_2_2,
		executables:[Executable.get('OpenBUGS')])

parswms_aug06 = new Package(
		application:parswms,
		version:Version.get('Aug06')
		)

paup_4_0_beta = new Package(
		application:paup,
		version:Version.get('4.0 beta')
		)

phyml_20120412 = new Package(
		application: phyml,
		version:Version.get('20120412'),
		module:module_phyml_20120412,
		executables:[
			Executable.get('phyml')])

phyml_20121208 = new Package(
		application: phyml,
		version:Version.get('20121208'),
		module:module_phyml_20121208,
		executables:[
			Executable.get('phyml-mpi')])


python_2_4 = new Package(
		application: python,
		version:Version.get('2.4'),
		executables:[Executable.get('python')])

python_2_5 = new Package(
		application: python,
		version:Version.get('2.5'),
		executables:[Executable.get('python')])

python_2_6 = new Package(
		application: python,
		version:Version.get('2.6'),
		module:module_python_2_6_virtualenv,
		executables:[
			Executable.get('python2.6')]
		)

python_2_6_2 = new Package(
		application: python,
		version:Version.get('2.6.2'),
		executables:[
			Executable.get('python2.6')]		
		)

python_2_7 = new Package(
		application: python,
		version:Version.get('2.7'),
		module:module_python_2_7_virtualenv,
		executables:[
			Executable.get('python2.7')])

qiime_1_4_0 = new Package(
		application: qiime,
		version:Version.get('1.4.0'),
		module:module_qiime_1_4_0,
		executables:[
			Executable.get('Qiime')])

r_2_5 = new Package(
		application:r,
		version:Version.get('2.5.0'),
		executables:[Executable.get('R')])

r_2_9 = new Package(
		application:r,
		version:Version.get('2.9.0'),
		executables:[Executable.get('R')])

r_2_10 = new Package(
		application:r,
		version:Version.get('2.10.0'),
		executables:[Executable.get('R')])

r_2_11 = new Package(
		application:r,
		version:Version.get('2.11.0'),
		executables:[Executable.get('R')])

r_2_13_0 = new Package(
		application:r,
		version:Version.get('2.13.0'),
		executables:[Executable.get('R')])

r_2_13_1 = new Package(
		application:r,
		version:Version.get('2.13.1'),
		executables:[Executable.get('R')])

r_2_14 = new Package(
		application:r,
		version:Version.get('2.14.0'),
		executables:[Executable.get('R')])

r_2_15 = new Package(
		application:r,
		version:Version.get('2.15.0'),
		executables:[Executable.get('R')])

r_2_15_3 = new Package(
	application:r,
	version:Version.get('2.15.3'),
	module:module_r_2_15_3,
	executables:[Executable.get('R')])

rmpisnow_2_9 = new Package(
		application:rmpisnow,
		version:Version.get('2.9.0'),
		executables:[
			Executable.get('RMPISNOW')]
		)

rmpisnow_2_11 = new Package(
		application:rmpisnow,
		version:Version.get('2.11.0'),
		executables:[Executable.get('RMPISNOW')])

rmpisnow_2_13_0 = new Package(
		application:rmpisnow,
		version:Version.get('2.13.0'),
		executables:[Executable.get('RMPISNOW')])

rmpisnow_2_13_1 = new Package(
		application:rmpisnow,
		version:Version.get('2.13.1'),
		executables:[Executable.get('RMPISNOW')])

rmpisnow_2_15_0 = new Package(
	application:rmpisnow,
	version:Version.get('2.15.0'),
	executables:[Executable.get('RMPISNOW')])

rmpisnow_2_15_3 = new Package(
	application:rmpisnow,
	version:Version.get('2.15.3'),
	module:module_r_2_15_3,
	executables:[Executable.get('RMPISNOW')])

sas_9_2 = new Package(
		application:sas,
		version:Version.get('9.2')
		)

sas_9_3 = new Package(
		application:sas,
		version:Version.get('9.3'),
		module:module_sas_9_3
		)

szybki_1_3_4 = new Package(
		application:szybki,
		version:Version.get('1.3.4'),
		executables:[Executable.get('szybki')])

teiresias_18aug2004 = new Package(
		application:teiresias,
		version:Version.get('18AUG2004')
		)

ultrabeast_0_1 = new Package(
		application:ultrabeast,
		module:module_ultrabeast_0_1,
		version:Version.get('0.1')
		)

unixcommands_5 = new Package(
		application:unixcommands,
		version:Version.get('5'),
		executables:Executable.getList('ls', 'cat', 'diff', 'echo','pwd')
		)

wrf_1_0 = new Package(
		application:wrf,
		version:Version.get('1.0')
		)

// queues

/** example:
 <id> = new Queue(
 gateway:<gateway>,	// required
 name:'<queuename>',	// required
 groups: [<list_of_groups>], // at least one value required
 directories:[<list_of_directories>], // at least one value required
 packages:[<list_of_packages>], // optional, default is just generic package
 description:'Description of the queue', // optional, default: 'n/a'
 hosts:<number_of_hosts_for_this_queue>, // optional, default: Integer.MAX_VALUE
 memory:<long_value_for_memory>, // optional, default: Long.MAX_VALUE
 cpus:<total_no_of_cpus>, 				// optional, default: Integer.MAX_VALUE
 virtualMemory:<long_value_for_memory>, // optional, default: Long.MAX_VALUE
 walltimeInMinutes:<walltime>, // optional, default: Integer.MAX_VALUE
 cpusPerHost:<min_number_of_cpus_per_host>, // optional, default: Integer.MAX_VALUE
 clockspeedInHz:<clockspeed>, // optional, default: Integer.MAX_VALUE
 */

// here we collect sets of packages, so we don't have to maintain those lists for every queue
auckland_default_packages = [
	beast_1_6_1,
	java_1_6,
	mr_bayes_3_2_1,
	//	r_2_15,
	//	rmpisnow_2_9,
	unixcommands_5,
	octave_3_0_5,
	python_2_6
]

pan_default_packages = [
	blast_2_2_26,
	blastplus_2_2_27,
	bowtie2_2_0_6,
	cegma_2_4,
	gcc_4_7_2,
	gold_5_1,
	gaussian_d_01,
	gromacs_4_5_4,
	gromacs_4_5_5,
	gromacs_4_6,
	hagfish_2013_03_14,
//	matlab_uoaabi,
	matlab_uoafoe,
	matlab_uoafos,
//	matlab_uoamath,
//	matlab_uoo,
	mothur_1_6_0,
	mpiblast_1_6,
	mr_bayes_3_2_1,
	nomad_3_5_1,
	openbugs_3_2_2,
	phyml_20120412,
	phyml_20121208,
	python_2_6,
	python_2_7,
	qiime_1_4_0,
	r_2_15,
	r_2_15_3,
	sas_9_3,
	rmpisnow_2_15_0,
	rmpisnow_2_15_3,
	ultrabeast_0_1,
	unixcommands_5
]
pan_gpu_packages = [
	gcc_4_7_2,
	python_2_6,
	python_2_7,
	unixcommands_5
]

gram5p7_common_packages = [
	mr_bayes_3_2_2,
	bayesphylogenies_1_0,
	modeltest_3_7,
	beast_1_6_1,
	clustalw_1_83,
	clustalwparallel_0_13,
	paup_4_0_beta,
	unixcommands_5,
	blast_2_2_21,
	mpiblast_1_6,
	teiresias_18aug2004,
	java_1_6
]

gram5p7_aix = [
	sas_9_2,
	namd_2_6,
	wrf_1_0,
	r_2_5,
	parswms_aug06,
	python_2_6_2,
	best_2_3_1
]+ gram5p7_common_packages

gram5p7_linux = [
	blastplus_2_2_27,
	lamarc_2_1,
	r_2_14,
	meme_4_1,
	infernal_1_0,
	python_2_6
]+ gram5p7_common_packages

gram5bgp_packages = [
	mr_bayes_3_2_2,
	namd_2_7b1,
	mpiblast_1_6
]

ng2sge_local_software = [
	mr_bayes_3_1_2,
	r_2_11,
	rmpisnow_2_11,
	unixcommands_5,
	octave_3_4_2
]

small_ngcompute = [
	mr_bayes_3_1_2,
	bayesphylogenies_1_0,
	lamarc_2_1,
	modeltest_3_7,
	beast_1_6_1,
	clustalw_1_83,
	clustalwparallel_0_13,
	paup_4_0_beta,
	unixcommands_5,
	java_1_6,
	meme_4_1,
	blender_2_49a,
	r_2_13_1,
	rmpisnow_2_13_1,
	python_2_4,
	best_2_3_1
]

ng2hpc_local_software = [
	beast_1_6_1,
	best_2_3_1,
	blast_2_2_21,
	bayesphylogenies_1_0,
	clustalw_1_83,
	clustalwparallel_0_13,
	java_1_6,
	lamarc_2_1,
	meme_4_1,
	modeltest_3_7,
	mr_bayes_3_1_2,
	namd_2_6,
	parswms_aug06,
	paup_4_0_beta,
	r_2_5,
	sas_9_2,
	unixcommands_5,
	wrf_1_0,
	infernal_1_0,
	mpiblast_1_6,
	python_2_5,
	teiresias_18aug2004
]

//scenz_packages = [
//	clustalw_2_0_11,
//	java_1_6,
//	mr_bayes_3_1_2,
//	python_2_4,
//	r_2_13_0,
//	rmpisnow_2_13_0,
//	unixcommands_5
//]

pan_pan = new Queue(
		gateway:pan,
		name:'pan',
		factoryType:'LL',
		groups:[nesi, uoa] + nesi_akl_groups,
		directories:[auckland_pan],
		packages:pan_default_packages,
		description:'Suitable for any jobs by NeSI members. Contains nodes with \'westmere\' and \'sandybridge\' architecture. More information: https://wiki.auckland.ac.nz/display/CERES/NeSI+Pan+Cluster',
		hosts:203,
		cpus:2956,
		cpusPerHost:20,
		clockspeedInHz:2800000000,
		memory:549755813888,
		virtualMemory:549755813888
		)

pan_gpu = new Queue(
		gateway:pan,
		name:'gpu',
		factoryType:'LL',
		groups:[nesi, uoa] + nesi_akl_groups,
		directories:[auckland_pan],
		packages:pan_gpu_packages,
		description:'GPU nodes on the Pan cluster. More information: https://wiki.auckland.ac.nz/display/CERES/NeSI+Pan+Cluster',
		hosts:2,
		cpus:24,
		cpusPerHost:12,
		clockspeedInHz:2800000000,
		memory:549755813888,
		virtualMemory:549755813888
		)

pan_stats = new Queue(
	gateway:pan,
	name:'stat',
	factoryType:'LL',
	groups:[uoa_stats_staff, uoa_stats_students],
	directories:[auckland_pan],
	packages:pan_default_packages,
	description:'Suitable for jobs by the statistics department',
	hosts:156,
	cpus:2096,
	cpusPerHost:20,
	clockspeedInHz:2800000000,
	memory:549755813888,
	virtualMemory:549755813888
	)


uoa_pan_comp_chem_ce = new Queue(
		gateway:pan,
		name:'chem',
		factoryType:'LL',
		groups:[uoa_comp_chem],
		directories:[auckland_pan],
		packages:pan_default_packages,
		hosts:1,
		cpusPerHost:40,
		cpus:40,
		memory:549755813888,
		virtualMemory:549755813888,
		clockspeedInHz:2700000000,
		description:'Queue for comp chem node on Pan'
		)



canterbury_p7aix = new Queue(
		gateway:canterbury_gram5p7,
		directories:[canterbury_gram5p7_home],
		name:'p7aix',
		factoryType:'LL',
		groups:[nesi, bestgrid, bluefern] + nesi_uoc_groups,
		packages:gram5p7_aix,
		hosts:11,
		cpus:352,
		cpusPerHost:32,
		memory:137438953472,
		virtualMemory:137438953472,
		clockspeedInHz:3300000000,
		walltimeInMinutes:4320,
		description:'Power7 running AIX, 32 CPUs and 128GB RAM per node, InfiniBand - for memory intensive or parallel jobs. 72 hours wall clock limit.'
		)

canterbury_p7linux = new Queue(
		gateway:canterbury_gram5p7,
		directories:[canterbury_gram5p7_home],
		name:'p7linux',
		factoryType:'LL',
		groups:[nesi, bestgrid, bluefern]  + nesi_uoc_groups,
		packages:gram5p7_linux,
		hosts:2,
		cpus:64,
		cpusPerHost:32,
		memory:137438953472,
		virtualMemory:137438953472,
		clockspeedInHz:3300000000,
		walltimeInMinutes:4320,
		description:'Power7 running SLES 11.1 Linux, 32 CPUs and 128GB RAM per node - for memory intensive or parallel jobs. 72 hours wall clock limit.'
		)

canterbury_bgp = new Queue(
		gateway:canterbury_gram5bgp,
		directories:[canterbury_gram5bgp_home],
		name:'bgp',
		factoryType:'LL',
		groups:[nesi, bluefern],
		packages:gram5bgp_packages,
		hosts:2048,
		cpus:8192,
		cpusPerHost:4,
		memory:4294967296,
		virtualMemory:4294967296,
		clockspeedInHz:850000000,
		walltimeInMinutes:4320,
		description:'BlueGene/P. Available to NeSI users with BlueGene/P allocation.  Only suitable for highly scalable jobs.'
		)


small_canterbury_ng2 = new Queue(
		gateway:canterbury_ng2,
		groups:[bestgrid],
		name:'small',
		factoryType:'PBS',
		directories:[canterbury_ng2_home],
		packages: small_ngcompute,
		hosts:1,
		cpus:4,
		cpusPerHost:4,
		memory:2147483648,
		virtualMemory:2147483648,
		clockspeedInHz:3000000000,
		walltimeInMinutes:4320,
		description:'Suitable for testing and serial and small parallel jobs'
		)

grid_aix_canterbury_ng2hpc = new Queue(
		gateway:canterbury_ng2hpc,
		groups:[bestgrid, bluefern],
		name:'grid_aix',
		factoryType:'Loadleveler',
		directories:[canterbury_ng2hpc_home],
		packages: ng2hpc_local_software,
		hosts:1,
		cpus:8,
		cpusPerHost:8,
		memory:68719476736,
		virtualMemory:68719476736,
		clockspeedInHz:3000000000,
		walltimeInMinutes:30240,
		description:'Suitable for testing and serial and small parallel jobs'
		)

medium64_oldesparky_canterbury_ng2sge = new Queue(
		gateway:canterbury_ng2sge,
		groups:[bestgrid],
		name:'medium64',
		factoryType:'SGE',
		directories:[canterbury_ng2sge_home],
		packages: ng2sge_local_software,
		hosts:16,
		cpus:88,
		cpusPerHost:8,
		memory:8589934592,
		virtualMemory:8589934592,
		clockspeedInHz:2000000000,
		walltimeInMinutes:14400,
		description:'x86_64 AMD cluster, 88 cores over 16 nodes (4-way and 8-way), suitable for serial and medium-size parallel jobs'
		)

//all_q_ng2_scenzgrid = new Queue(
//		gateway:landcare_gram4,
//		groups:[bestgrid,landcare_users],
//		name:'all.q',
//		packages:scenz_packages,
//		factoryType:'SGE',
//		directories:[scenzgrid_home],
//		description:'Cluster for landcare users',
//		hosts:12,
//		cpus:96,
//		cpusPerHost:8,
//		memory:34359738368,
//		virtualMemory:34359738368,
//		clockspeedInHz:2800000000,
//		)
