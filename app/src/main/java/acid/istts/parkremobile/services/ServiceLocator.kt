package acid.istts.parkremobile.services

import acid.istts.parkremobile.repositories.CustomerRepository
import acid.istts.parkremobile.repositories.MallRepository
import acid.istts.parkremobile.repositories.SegmentationRepository
import acid.istts.parkremobile.repositories.StaffRepository

class ServiceLocator {
    companion object {
        private var instance: ServiceLocator? = null
        fun getInstance(): ServiceLocator {
            if (instance == null) {
                instance = ServiceLocator()
            }
            return instance!!
        }
    }

    fun getStaffRepository(): StaffRepository {
        return StaffRepository.getInstance()
    }

    fun getCustomerRepository(): CustomerRepository {
        return CustomerRepository.getInstance()
    }

    fun getMallRepository(): MallRepository {
        return MallRepository.getInstance()
    }

    fun getSegmentationRepository(): SegmentationRepository {
        return SegmentationRepository.getInstance()
    }
}