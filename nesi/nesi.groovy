import nz.org.nesi.gridinfo.InfoFileManager
import grisu.jcommons.model.info.*


// variables
def auckland_available = true

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

nesi_merit = new Group(
        vo = nz,
        fqan = "/nz/nesi/projects"
)

fhms = new Group(
        vo = nz,
        fqan = "/nz/nesi/fhms"
)

pfr = new Group(
        vo = nz,
        fqan = "/nz/pfr"
)

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
        host: 'df.auckland.ac.nz',
        site: auckland,
        available: true
)

canterbury_df_fs = new FileSystem(
        host: 'df.bestgrid.org',
        site: canterbury,
        available: false
)

canterbury_df_dev_fs = new FileSystem(
        host: 'gridgwtest.canterbury.ac.nz',
        site: canterbury,
        available: false
)

auckland_pan_fs = new FileSystem(
        host: 'gram.uoa.nesi.org.nz',
        site: auckland,
        available: auckland_available
)

canterbury_ng1_fs = new FileSystem(
        host: 'ng1.canterbury.ac.nz',
        site: canterbury,
        available: true
)

canterbury_ng2_fs = new FileSystem(
        host: 'ng2.canterbury.ac.nz',
        site: canterbury,
        available: true
)

canterbury_ng2hpc_fs = new FileSystem(
        host: 'ng2hpc.canterbury.ac.nz',
        site: canterbury,
        available: true
)

canterbury_ng2sge_fs = new FileSystem(
        host: 'ng2sge.canterbury.ac.nz',
        site: canterbury,
        available: true
)

canterbury_gram5bgp_fs = new FileSystem(
        host: 'gram5bgp.canterbury.ac.nz',
        site: canterbury,
        available: true
)

canterbury_gram5p7_fs = new FileSystem(
        host: 'gram5p7.canterbury.ac.nz',
        site: canterbury,
        available: true
)

// nesi merit groups (Auckland)
def merit_project_group_names = (1..200)

// nesi merit groups (Canterbury)
def nesi_uoc_groups = []
merit_project_group_names.each {
    nesi_uoc_groups.add(new Group(vo = nz, fqan = "/nz/nesi/projects/nesi" + String.format("%05d", it)))
}
nesi_uoc_groups.add(new Group(vo = nz, fqan = "/nz/nesi/projects/test99999"))  // testgroup


def pan_projects = [:]
def pan_project_groups = []
def pan_project_folders = []

pan_projects['uoa'] = (1..400) + [99998, 99999]
pan_projects['landcare'] = (1..80)
pan_projects['uoo'] = (1..50)
pan_projects['nesi'] = merit_project_group_names


// adding all project groups & folders for pan
pan_projects.each() { collaborator, groups_numbers ->

    groups_numbers.each() { name ->
        def tempName = collaborator + String.format("%05d", name)

        def tempGroup = new Group(vo = nz, fqan = "/nz/"+collaborator+"/projects/" + tempName)

        pan_project_groups.add(tempGroup)

        def tempDir = new Directory(
                filesystem: auckland_pan_fs,
                groups: [tempGroup],
                alias: "pan_home_" + name,
                path: "/gpfs1m/projects/" + tempName,
                options: [volatileDirectory: false, globusOnline: false, shared: true],
                available: auckland_available
        )
        pan_project_folders.add(tempDir)
    }

}

// directories (make sure to always have a trailing slash for the path element
auckland_cluster_groups = [
        grid_dev,
        fhms,
        pfr,
        uoa_comp_chem,
        uoa_gaussian,
        uoa_comp_evol,
        uoa_eng_sci,
        uoa_math,
        uoa_mech_eng,
        uoa_qoptics,
        uoa_stats,
        uoa_stats_staff,
        uoa_stats_students,
        uoa_virt_screening,
        uoa_vs_jobs
] + pan_project_groups

auckland_pan = new Directory(
        filesystem: auckland_pan_fs,
        groups: [uoa, landcare_users, uoo, nesi_merit],
        alias: "pan",
        path: "/~/",
        options: [volatileDirectory: false, globusOnline: true],
        available: auckland_available
)

auckland_df_home = new Directory(
        filesystem: auckland_df_fs,
        groups: [nesi],
        path: "/~/",
        alias: "datafabric",
        options: [volatileDirectory: false, globusOnline: true]
)

canterbury_df_home = new Directory(
        filesystem: canterbury_df_fs,
        groups: [nesi],
        path: "/~/",
        alias: "datafabric_chch",
        options: [volatileDirectory: false, globusOnline: true]
)

canterbury_df_dev_home = new Directory(
        filesystem: canterbury_df_fs,
        groups: [nesi],
        path: "/~/",
        alias: "datafabric_dev_chch",
        options: [volatileDirectory: false, globusOnline: true]
)

auckland_vs_group = new Directory(
        filesystem: auckland_pan_fs,
        groups: [uoa_virt_screening],
        path: "/home/grid-vs/",
        alias: "virtual_screening",
        options: [volatileDirectory: false, globusOnline: true, shared: true],
        available: auckland_available
)

auckland_vs_jobs_group = new Directory(
        filesystem: auckland_pan_fs,
        groups: [uoa_vs_jobs],
        path: "/~/",
        alias: "virtual_screening",
        options: [volatileDirectory: false, globusOnline: true, shared: false],
        available: auckland_available
)

auckland_acsrc_group = new Directory(
        filesystem: auckland_pan_fs,
        groups: [uoa_acsrc],
        alias: "vs-acsrc",
        options: [volatileDirectory: false, globusOnline: true],
        path: "/home/grid-acsrc/",
        available: auckland_available
)

auckland_sbs_group = new Directory(
        filesystem: auckland_pan_fs,
        groups: [uoa_sbs],
        options: [volatileDirectory: false, globusOnline: true],
        alias: "vs-sbs",
        path: "/home/grid-sbs/",
        available: auckland_available
)

canterbury_ng1_home = new Directory(
        filesystem: canterbury_ng1_fs,
        groups: [bestgrid],
        path: "/~/",
        alias: "blufern-ng1",
        options: [volatileDirectory: true, globusOnline: true],
        available: true
)

canterbury_ng2_home = new Directory(
        filesystem: canterbury_ng2_fs,
        groups: [bestgrid],
        path: "/~/",
        alias: "bluefern-ng2",
        options: [volatileDirectory: true, globusOnline: true],
        available: true
)

canterbury_ng2hpc_home = new Directory(
        filesystem: canterbury_ng2hpc_fs,
        groups: [bestgrid, bluefern],
        path: "/~/",
        options: [volatileDirectory: true, globusOnline: true],
        available: true
)

canterbury_gram5p7_home = new Directory(
        filesystem: canterbury_gram5p7_fs,
        groups: [bestgrid, bluefern] + nesi_uoc_groups,
        path: "/~/",
        alias: "bluefern-p7",
        options: [volatileDirectory: true, globusOnline: true],
        available: true
)

canterbury_ng2sge_home = new Directory(
        filesystem: canterbury_ng2sge_fs,
        groups: [bestgrid],
        path: "/~/",
        alias: "bluefern-sge",
        options: [volatileDirectory: true, globusOnline: true],
        available: true
)

canterbury_gram5bgp_home = new Directory(
        filesystem: canterbury_gram5bgp_fs,
        groups: [bluefern],
        path: "/~/",
        alias: "bluefern-bgp",
        options: [volatileDirectory: true, globusOnline: true],
        available: true
)

globus4 = Middleware.get("Globus", "4.0.0")
globus5 = Middleware.get("Globus", "5.0")

gram52_akl = new Middleware(
        name: 'Globus',
        version: '5.2',
        options: [prologEpilogAvailable: true]
)

// gateways
pan = new Gateway(
        site: auckland,
        host: "gram.uoa.nesi.org.nz",
        middleware: gram52_akl,
        available: auckland_available
)

canterbury_ng2 = new Gateway(
        site: canterbury,
        host: "ng2.canterbury.ac.nz",
        middleware: globus4
)

canterbury_ng1 = new Gateway(
        site: canterbury,
        host: "ng1.canterbury.ac.nz",
        middleware: globus5
)

canterbury_ng2hpc = new Gateway(
        site: canterbury,
        host: "ng2hpc.canterbury.ac.nz",
        middleware: globus4
)

canterbury_ng2sge = new Gateway(
        site: canterbury,
        host: "ng2sge.canterbury.ac.nz",
        middleware: globus4
)

canterbury_gram5p7 = new Gateway(
        site: canterbury,
        host: "gram5p7.canterbury.ac.nz",
        middleware: globus5
)

canterbury_gram5bgp = new Gateway(
        site: canterbury,
        host: "gram5bgp.canterbury.ac.nz",
        middleware: globus5
)

def pan_default_packages = InfoFileManager.createPackageList('git://github.com/nesi/applications.git', true)
def pan_no_modules = InfoFileManager.createPackageList('auckland/pan_no_module.list')

pan_packages = pan_default_packages + pan_no_modules

pan_gpu_packages = InfoFileManager.createPackageList('auckland/gpu.list')

gram5p7_aix = InfoFileManager.createPackageList('bluefern/gram5p7_aix.list')

gram5p7_linux = InfoFileManager.createPackageList('bluefern/gram5p7_linux.list')

gram5bgp_packages = InfoFileManager.createPackageList('bluefern/gram5bgp.list')

ng2sge_local_software = InfoFileManager.createPackageList('bluefern/ng2sge.list')

small_ngcompute = InfoFileManager.createPackageList('bluefern/small_ngcompute.list')

ng2hpc_local_software = InfoFileManager.createPackageList('bluefern/ng2hpc.list')


pan_pan = new Queue(
        gateway: pan,
        name: 'pan',
        factoryType: 'LL',
        groups: auckland_cluster_groups,
        directories: pan_project_folders + auckland_vs_jobs_group,
        packages: pan_packages,
        description: 'Suitable for any jobs by NeSI members. Contains nodes with \'westmere\' and \'sandybridge\' architecture. More information: https://wiki.auckland.ac.nz/display/CERES/NeSI+Pan+Cluster',
        hosts: 203,
        cpus: 2956,
        cpusPerHost: 20,
        clockspeedInHz: 2800000000,
        memory: 549755813888,
        virtualMemory: 549755813888,
        options: [alias: 'pan,pan:pan.nesi.org.nz']
)

pan_gpu = new Queue(
        gateway: pan,
        name: 'gpu',
        factoryType: 'LL',
        //groups: auckland_cluster_groups,
        groups: [grid_dev],
        directories: pan_project_folders + auckland_vs_group,
        packages: pan_gpu_packages,
        description: 'GPU nodes on the Pan cluster. More information: https://wiki.auckland.ac.nz/display/CERES/NeSI+Pan+Cluster',
        hosts: 2,
        cpus: 24,
        cpusPerHost: 12,
        clockspeedInHz: 2800000000,
        memory: 549755813888,
        virtualMemory: 549755813888,
        options: [alias: 'gpu:pan.nesi.org.nz']
)

pan_fhms = new Queue(
        gateway: pan,
        name: 'fhms',
        factoryType: 'LL',
        groups: [fhms],
        directories: [auckland_pan],
        packages: pan_packages,
        description: 'Suitable for any jobs by NeSI members. Contains nodes with \'westmere\' and \'sandybridge\' architecture. More information: https://wiki.auckland.ac.nz/display/CERES/NeSI+Pan+Cluster',
        hosts: 203,
        cpus: 2956,
        cpusPerHost: 20,
        clockspeedInHz: 2800000000,
        memory: 549755813888,
        virtualMemory: 549755813888,
        options: [alias: 'pan,pan:pan.nesi.org.nz']
)

pan_stats = new Queue(
        gateway: pan,
        name: 'stat',
        factoryType: 'LL',
        groups: [uoa_stats_staff, uoa_stats_students],
        directories: [auckland_pan],
        packages: pan_packages,
        description: 'Suitable for jobs by the statistics department',
        hosts: 156,
        cpus: 2096,
        cpusPerHost: 20,
        clockspeedInHz: 2800000000,
        memory: 549755813888,
        virtualMemory: 549755813888,
        options: [alias: 'stat,stat:pan.nesi.org.nz']
)


uoa_pan_comp_chem_ce = new Queue(
        gateway: pan,
        name: 'chem',
        factoryType: 'LL',
        groups: [uoa_comp_chem],
        directories: [auckland_pan],
        packages: pan_packages,
        hosts: 1,
        cpusPerHost: 40,
        cpus: 40,
        memory: 549755813888,
        virtualMemory: 549755813888,
        clockspeedInHz: 2700000000,
        description: 'Queue for comp chem node on Pan',
        options: [alias: 'chem,chem:pan.nesi.org.nz']
)



canterbury_p7aix = new Queue(
        gateway: canterbury_gram5p7,
        directories: [canterbury_gram5p7_home],
        name: 'p7aix',
        factoryType: 'LL',
        groups: [bestgrid, bluefern] + nesi_uoc_groups,
        packages: gram5p7_aix,
        hosts: 11,
        cpus: 352,
        cpusPerHost: 32,
        memory: 137438953472,
        virtualMemory: 137438953472,
        clockspeedInHz: 3300000000,
        walltimeInMinutes: 4320,
        description: 'Power7 running AIX, 32 CPUs and 128GB RAM per node, InfiniBand - for memory intensive or parallel jobs. 72 hours wall clock limit.'
)

canterbury_p7linux = new Queue(
        gateway: canterbury_gram5p7,
        directories: [canterbury_gram5p7_home],
        name: 'p7linux',
        factoryType: 'LL',
        groups: [bestgrid, bluefern] + nesi_uoc_groups,
        packages: gram5p7_linux,
        hosts: 2,
        cpus: 64,
        cpusPerHost: 32,
        memory: 137438953472,
        virtualMemory: 137438953472,
        clockspeedInHz: 3300000000,
        walltimeInMinutes: 4320,
        description: 'Power7 running SLES 11.1 Linux, 32 CPUs and 128GB RAM per node - for memory intensive or parallel jobs. 72 hours wall clock limit.'
)

canterbury_bgp = new Queue(
        gateway: canterbury_gram5bgp,
        directories: [canterbury_gram5bgp_home],
        name: 'bgp',
        factoryType: 'LL',
        groups: [bluefern],
        packages: gram5bgp_packages,
        hosts: 2048,
        cpus: 8192,
        cpusPerHost: 4,
        memory: 4294967296,
        virtualMemory: 4294967296,
        clockspeedInHz: 850000000,
        walltimeInMinutes: 4320,
        description: 'BlueGene/P. Available to NeSI users with BlueGene/P allocation.  Only suitable for highly scalable jobs.'
)


small_canterbury_ng2 = new Queue(
        gateway: canterbury_ng2,
        groups: [bestgrid],
        name: 'small',
        factoryType: 'PBS',
        directories: [canterbury_ng2_home],
        packages: small_ngcompute,
        hosts: 1,
        cpus: 4,
        cpusPerHost: 4,
        memory: 2147483648,
        virtualMemory: 2147483648,
        clockspeedInHz: 3000000000,
        walltimeInMinutes: 4320,
        description: 'Suitable for testing and serial and small parallel jobs'
)

grid_aix_canterbury_ng2hpc = new Queue(
        gateway: canterbury_ng2hpc,
        groups: [bestgrid, bluefern],
        name: 'grid_aix',
        factoryType: 'Loadleveler',
        directories: [canterbury_ng2hpc_home],
        packages: ng2hpc_local_software,
        hosts: 1,
        cpus: 8,
        cpusPerHost: 8,
        memory: 68719476736,
        virtualMemory: 68719476736,
        clockspeedInHz: 3000000000,
        walltimeInMinutes: 30240,
        description: 'Suitable for testing and serial and small parallel jobs'
)

medium64_oldesparky_canterbury_ng2sge = new Queue(
        gateway: canterbury_ng2sge,
        groups: [bestgrid],
        name: 'medium64',
        factoryType: 'SGE',
        directories: [canterbury_ng2sge_home],
        packages: ng2sge_local_software,
        hosts: 16,
        cpus: 88,
        cpusPerHost: 8,
        memory: 8589934592,
        virtualMemory: 8589934592,
        clockspeedInHz: 2000000000,
        walltimeInMinutes: 14400,
        description: 'x86_64 AMD cluster, 88 cores over 16 nodes (4-way and 8-way), suitable for serial and medium-size parallel jobs'
)


