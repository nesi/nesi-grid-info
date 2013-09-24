

import nz.org.nesi.gridinfo.InfoFileManager
import grisu.jcommons.model.info.*


// variables

// the numbers of the merit groups that have access to the auckland cluster
akl_project_groups = [2, 11, 12, 13, 28, 30, 31, 35, 39, 60, 99999]
uoc_project_groups = [12, 31]

// sites
auckland = new Site(
        name = 'Auckland'
)


// vos
nz = new VO(
        voName = 'nz',
        host = 'voms.bestgrid.org',
        port = 15000,
        hostDN = '/C=TW/O=AP/OU=GRID/CN=voms.bestgrid.org'
)


nesi = new Group(
        vo = nz,
        fqan = "/nz/nesi"
)

auckland_pan_fs = new FileSystem(
        host: 'pan.nesi.org.nz',
        site: auckland,
        available: true
)



// directories (make sure to always have a trailing slash for the path element
auckland_cluster_groups = [
        nesi
]


auckland_pan = new Directory(
        filesystem: auckland_pan_fs,
        groups: auckland_cluster_groups,
        alias: "pan",
        options: [volatileDirectory: true, globusOnline: true],
        available: true
)

globus4 = Middleware.get("Globus", "4.0.0")
globus5 = Middleware.get("Globus", "5.0")

// gateways
pan = new Gateway(
        site: auckland,
//        host: "gram.uoa.nesi.org.nz",
        host: "pan.nesi.org.nz",
        middleware: globus5
)


//def pan_default_packages = InfoFileManager.createPackageList('git://github.com/nesi/applications.git', true)
def pan_no_modules = InfoFileManager.createPackageList('auckland/pan_no_module.list')

pan_packages = pan_no_modules

pan_gpu_packages = InfoFileManager.createPackageList('auckland/gpu.list')



pan_pan = new Queue(
        gateway: pan,
        name: 'pan',
        factoryType: 'LL',
        groups: [nesi],
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

pan_gpu = new Queue(
        gateway: pan,
        name: 'gpu',
        factoryType: 'LL',
        groups: [nesi],
        directories: [auckland_pan],
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
