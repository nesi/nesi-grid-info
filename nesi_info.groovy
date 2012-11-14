import grisu.jcommons.model.info.*




// variables

// the numbers of the merit groups that have access to the auckland cluster
akl_project_groups = [2,13,28,30,31,35,99999]
uoc_project_groups = [31]

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
		hostDN = '/C=NZ/O=BeSTGRID/OU=The University of Auckland/CN=voms.bestgrid.org'
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

demo = new Group(
		vo = nz,
		fqan = "/nz/demo"
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



// filesystems
auckland_gram5_fs = new FileSystem(
		host:'gram5.ceres.auckland.ac.nz',
		site:auckland
		)

auckland_df_fs = new FileSystem(
		host:'df.auckland.ac.nz',
		site:auckland
		)

auckland_pan_fs = new FileSystem(
		host:'pan.nesi.org.nz',
		site:auckland
		)

canterbury_ng1_fs = new FileSystem(
		host:'ng1.canterbury.ac.nz',
		site:canterbury
		)

canterbury_ng2_fs = new FileSystem(
		host:'ng2.canterbury.ac.nz',
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

scenzgrid_fs = new FileSystem(
		host:'ng2.scenzgrid.org',
		site:landcare
		)

// directories (make sure to always have a trailing slash for the path element
auckland_cluster_groups = [
	bestgrid,
	demo,
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

auckland_home = new Directory(
		filesystem:auckland_gram5_fs,
		groups:auckland_cluster_groups,
		path:"/~/",
		volatileDirectory:true
		)

auckland_pan = new Directory(
		filesystem:auckland_pan_fs,
		groups:auckland_cluster_groups,
		volatileDirectory:true
		)

auckland_df_home = new Directory(
		filesystem:auckland_df_fs,
		groups:[nesi],
		path:"/~/",
		volatileDirectory:false
		)

auckland_vs_group = new Directory(
		filesystem:auckland_pan_fs,
		groups:[uoa_virt_screening],
		volatileDirectory:false,
		path:"/home/grid-vs/",
		shared:false
		)

auckland_acsrc_group = new Directory(
		filesystem:auckland_pan_fs,
		groups:[uoa_acsrc],
		volatileDirectory:false,
		path:"/home/grid-acsrc/"
		)

auckland_sbs_group = new Directory(
		filesystem:auckland_pan_fs,
		groups:[uoa_sbs],
		volatileDirectory:false,
		path:"/home/grid-sbs/"
		)

canterbury_ng1_home = new Directory(
		filesystem:canterbury_ng1_fs,
		groups:[nesi, bestgrid],
		path:"/~/",
		volatileDirectory:true
		)

canterbury_ng2_home = new Directory(
		filesystem:canterbury_ng2_fs,
		groups:[nesi, bestgrid],
		path:"/~/",
		volatileDirectory:true
		)

canterbury_gram5p7_home = new Directory(
		filesystem:canterbury_gram5p7_fs,
		groups:[nesi, bestgrid, bluefern] + nesi_uoc_groups,
		path:"/~/",
		volatileDirectory:true
		)

canterbury_ng2sge_home = new Directory(
		filesystem:canterbury_ng2sge_fs,
		groups:[nesi, bestgrid],
		path:"/~/",
		volatileDirectory:true
		)

canterbury_gram5bgp_home = new Directory(
		filesystem:canterbury_gram5bgp_fs,
		groups:[nesi, bluefern],
		path:"/~/",
		volatileDirectory:true
		)

scenzgrid_home = new Directory(
		filesystem:scenzgrid_fs,
		groups:[bestgrid],
		volatileDirectory:true,
		path:'/~/'
		)

globus4 = Middleware.get("Globus", "4.0.0")
globus5 = Middleware.get("Globus", "5.0")


// gateways
gram5 = new Gateway(
		site:auckland,
		host:"gram5.ceres.auckland.ac.nz",
		middleware:globus5
		)

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

landcare_gram4 = new Gateway(
		site:landcare,
		host:"ng2.scenzgrid.org",
		middleware:globus4
		)



// Applications

abaqus = Application.get('Abaqus')
beast = Application.get('BEAST')
best = Application.get('BEST')
bayesphylogenies = Application.get('BayesPhylogenies')
blast = Application.get('BLAST')
blastplus = Application.get('BLAST+')
blender = Application.get('Blender')
cegma = Application.get('cegma')
clustalw = Application.get('ClustalW')
clustalwparallel = Application.get('ClustalW Parallel')
gold = Application.get('Gold')
gromacs = Application.get('GROMACS')
infernal = Application.get('infernal')
java = Application.get('Java')
lamarc = Application.get('LAMARC')
meme = Application.get('MEME')
modeltest = Application.get('ModelTest')
mono = Application.get('mono')
mrbayes = Application.get('MrBayes')
namd = Application.get('NAMD')
nomad = Application.get('nomad')
paup = Application.get('PAUP*')
parswms = Application.get('PARSWMS')
r = Application.get('R')
rmpisnow = Application.get('RMPISNOW')
sas = Application.get('SAS')
unixcommands = Application.get('UnixCommands')
ilog = Application.get('ilog')
mpiblast = Application.get('mpiBLAST')
octave = Application.get('octave')
python = Application.get('python')
szybki = Application.get('szybki')
teiresias = Application.get('teiresias')
wrf = Application.get('WRF')


// modules
python_2_7_virtualenv = Module.create('python/2.7_virtualenv')
module_cegma_2_4 = Module.create('cegma/2.4')
module_gromacs_4_5_4 = Module.create('gromacs/4.5.4')


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

gold_5_1 = new Package(
		application:gold,
		version:Version.get('5.1'),
		executables:[
			Executable.get('parallel_gold_auto')]
		)

gromacs_4_5_4 = new Package(
		application:gromacs,
		version:Version.get('4.5.4'),
		module:module_gromacs_4_5_4,
		executables:[
			Executable.get('mdrun'), Executable.get('mdrun_mpi'), Executable.get('grompp'), Executable.get('grompp_mpi')
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

parswms_aug06 = new Package(
		application:parswms,
		version:Version.get('Aug06')
		)

paup_4_0_beta = new Package(
		application:paup,
		version:Version.get('4.0 beta')
		)

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
		executables:[
			Executable.get('python2.6')]
		)

python_2_6_2 = new Package(
		application: python,
		version:Version.get('2.6.2'),
		executables:[
			Executable.get('python2.6')]		)

python_2_7 = new Package(
		application: python,
		version:Version.get('2.7'),
		module:python_2_7_virtualenv,
		executables:[
			Executable.get('python2.7')])

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

sas_9_2 = new Package(
		application:sas,
		version:Version.get('9.2')
		)

szybki_1_3_4 = new Package(
		application:szybki,
		version:Version.get('1.3.4'),
		executables:[Executable.get('szybki')])

teiresias_18aug2004 = new Package(
		application:teiresias,
		version:Version.get('18AUG2004')
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
	mpiblast_1_6,
	mr_bayes_3_2_1,
	nomad_3_5_1,
	r_2_15,
	rmpisnow_2_15_0,
	unixcommands_5,
	python_2_7,
	gold_5_1,
	gromacs_4_5_4,
	cegma_2_4
]

gram5p7_common_packages = [
	mr_bayes_3_2_1,
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
	mr_bayes_3_2_1,
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
	r_2_11,
	r_2_13_1,
	r_2_5,
	r_2_14,
	sas_9_2,
	unixcommands_5,
	wrf_1_0,
	infernal_1_0,
	mpiblast_1_6,
	python_2_4,
	python_2_5,
	python_2_6,
	python_2_6_2,
	teiresias_18aug2004
]

scenz_packages = [
	clustalw_2_0_11,
	java_1_6,
	mr_bayes_3_1_2,
	python_2_4,
	r_2_13_0,
	rmpisnow_2_13_0,
	unixcommands_5
]

pan_pan = new Queue(
		gateway:pan,
		name:'pan',
		groups:[bestgrid, nesi] + nesi_akl_groups,
		directories:[auckland_pan],
		packages:pan_default_packages,
		description:'Suitable for any jobs by NeSI members',
		hosts:80,
		cpus:960,
		cpusPerHost:12,
		clockspeedInHz:2800000000,
		memory:137438953472,
		virtualMemory:137438953472
		)

pan_gpu = new Queue(
		gateway:pan,
		name:'gpu',
		groups:[bestgrid, nesi] + nesi_akl_groups,
		directories:[auckland_pan],
		packages:pan_default_packages,
		description:'GPU nodes on the Pan cluster',
		hosts:2,
		cpus:24,
		cpusPerHost:12,
		clockspeedInHz:2800000000,
		memory:103079215104,
		virtualMemory:103079215104
		)

default_gram5 = new Queue(
		gateway:gram5,
		name:'default',
		groups:[
			bestgrid,
			demo,
			grid_dev,
			nesi
		],
		directories:[auckland_home],
		packages:auckland_default_packages,
		description:'Suitable for any jobs by NeSI members',
		hosts:21,
		cpus:252,
		cpusPerHost:12,
		memory:25265145118,
		virtualMemory:25265145118
		)

demo_gram5 = new Queue(
		gateway:gram5,
		name:'demo',
		groups:[demo],
		directories:[auckland_home],
		packages:auckland_default_packages,
		description:'Test queue for demo group users',
		hosts:21,
		cpus:252,
		cpusPerHost:12,
		memory:25265145118,
		virtualMemory:25265145118
		)

test_gram5 = new Queue(
		gateway:gram5,
		name:'test',
		groups:[grid_dev],
		directories:[auckland_home],
		packages:auckland_default_packages,
		description:'Test queue for grid developers',
		hosts:21,
		cpus:252,
		cpusPerHost:12,
		memory:25265145118,
		virtualMemory:25265145118
		)

uoa_gpu = new Queue(
		gateway:gram5,
		name:'gpu',
		groups:[nesi],
		directories:[auckland_home],
		packages:auckland_default_packages,
		description:'Suitable for any jobs using the CUDA GPU framework. If you would like to use an alternative framework please contact eresearch-admin@list.auckland.ac.nz',
		hosts:2,
		cpus:16,
		cpusPerHost:16,
		clockspeedInHz:2340000000,
		memory:50637664419,
		virtualMemory:50637664419
		)

uoa_gold_ce = new Queue(
		gateway:pan,
		name:'gold',
		groups:[uoa_vs_jobs],
		directories:[auckland_home],
		packages:[gold_5_1])

uoa_mech_ce = new Queue(
		gateway:gram5,
		name:'uoamech',
		groups:[uoa_mech_eng],
		directories:[auckland_home],
		packages:auckland_default_packages,
		hosts:4,
		cpus:48,
		cpusPerHost:12,
		clockspeedInHz:2670000000,
		memory:2147483648,
		description:'MechEng node'
		)

uoa_math_ce = new Queue(
		gateway:gram5,
		name:'uoamath',
		groups:[uoa_math],
		directories:[auckland_home],
		packages:auckland_default_packages,
		hosts:1,
		cpus:40,
		cpusPerHost:40,
		memory:541316203151,
		virtualMemory:541316203151,
		clockspeedInHz:1950000000,
		description:'Queue for math node'
		)

uoa_stats_ce = new Queue(
		gateway:gram5,
		name:'uoastats',
		groups:[uoa_stats_staff],
		packages:auckland_default_packages,
		directories:[auckland_home],
		hosts:1,
		cpus:40,
		cpusPerHost:40,
		memory:541316203151,
		virtualMemory:541316203151,
		clockspeedInHz:1950000000,
		description:'Queue for stats node (staff)'
		)

uoa_pan_comp_chem_ce = new Queue(
		gateway:pan,
		name:'chem',
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

uoa_stats_students_ce = new Queue(
		gateway:gram5,
		name:'sstudents',
		groups:[uoa_stats_students],
		packages:auckland_default_packages,
		directories:[auckland_home],
		hosts:1,
		cpus:40,
		cpusPerHost:40,
		memory:541316203151,
		virtualMemory:541316203151,
		clockspeedInHz:1950000000,
		description:'Queue for stats node (students)'
		)

uoa_comp_evol_ce = new Queue(
		gateway:gram5,
		name:'uoaevol',
		groups:[uoa_comp_evol],
		directories:[auckland_home],
		packages:auckland_default_packages,
		hosts:5,
		cpusPerHost:12,
		cpus:60,
		memory:10468982784,
		virtualMemory:10468982784,
		clockspeedInHz:2600000000,
		description:'Queue for computational evolution users'
		)

uoa_comp_chem_ce = new Queue(
		gateway:gram5,
		name:'uoacompchem',
		groups:[uoa_comp_chem],
		directories:[auckland_home],
		packages:auckland_default_packages,
		description:'Queue for comp_chem users',
		hosts:21,
		cpus:252,
		cpusPerHost:12,
		memory:25265145118,
		virtualMemory:25265145118
		)

uoa_eng_sci_ce = new Queue(
		gateway:gram5,
		name:'uoaengsci',
		groups:[uoa_eng_sci],
		directories:[auckland_home],
		packages:auckland_default_packages,
		hosts:2,
		cpusPerHost:12,
		cpus:24,
		memory:25265145118,
		virtualMemory:25265145118,
		clockspeedInHz:2610000000,
		description:'Queue for engineering sciences users'
		)

uoa_q_optics_ce = new Queue(
		gateway:gram5,
		name:'uoaqoptics',
		groups:[uoa_qoptics],
		directories:[auckland_home],
		packages:auckland_default_packages,
		hosts:4,
		cpusPerHost:12,
		cpus:48,
		memory:25265145118,
		virtualMemory:25265145118,
		clockspeedInHz:2610000000,
		description:'Queue for quantum optics users'
		)

canterbury_p7aix = new Queue(
		gateway:canterbury_gram5p7,
		directories:[canterbury_gram5p7_home],
		name:'p7aix',
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
		groups:[nesi, bestgrid],
		name:'small',
		directories:[canterbury_ng2_home],
		packages: small_ngcompute,
		hosts:1,
		cpus:4,
		cpusPerHost:4,
		memory:2147483648,
		virtualMemory:2147483648,
		clockspeedInHz:3000000000,
		walltimeInMinutes:30240,
		description:'Suitable for testing and serial jobs'
		)

medium64_oldesparky_canterbury_ng2sge = new Queue(
		gateway:canterbury_ng2sge,
		groups:[nesi, bestgrid],
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

all_q_ng2_scenzgrid = new Queue(
		gateway:landcare_gram4,
		groups:[bestgrid],
		name:'all.q',
		packages:scenz_packages,
		factoryType:'SGE',
		directories:[scenzgrid_home],
		description:'Cluster for landcare users',
		hosts:12,
		cpus:96,
		cpusPerHost:8,
		memory:34359738368,
		virtualMemory:34359738368,
		clockspeedInHz:2800000000,
		)
