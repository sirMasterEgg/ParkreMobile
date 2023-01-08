package acid.istts.parkremobile.services

import acid.istts.parkremobile.datasources.*
import acid.istts.parkremobile.interfaces.CustomerDAO
import acid.istts.parkremobile.repositories.*
import android.view.View

class ServiceLocator {
    private val _baseUrl = "https://parkre.loca.lt/api/"

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
        return StaffRepository.getInstance(
            StaffDataSource.getInstance(_baseUrl)
        )
    }

    fun getCustomerRepository(): CustomerRepository {
        return CustomerRepository.getInstance(
            CustomerDataSource.getInstance(_baseUrl)
        )
    }

    fun getMallRepository(): MallRepository {
        return MallRepository.getInstance(
            MallDataSource.getInstance(_baseUrl)
        )
    }

    fun getSegmentationRepository(): SegmentationRepository {
        return SegmentationRepository.getInstance(
            SegmentationDataSource.getInstance(_baseUrl)
        )
    }

    fun getJobRepository(): JobRepository {
        return JobRepository.getInstance(
            JobDataSource.getInstance(_baseUrl)
        )
    }

    fun getReservationRepository(): ReservationRepository {
        return ReservationRepository.getInstance(
            ReservationDataSource.getInstance(_baseUrl)
        )
    }

    fun getReviewRepository(): ReviewRepository {
        return ReviewRepository.getInstance(
            ReviewDataSource.getInstance(_baseUrl)
        )
    }

    fun getTransactionRepository(): TransactionRepository {
        return TransactionRepository.getInstance(
            TransactionDataSource.getInstance(_baseUrl)
        )
    }

    fun getVehicleRepository(): VehicleRepository {
        return VehicleRepository.getInstance(
            VehicleDataSource.getInstance(_baseUrl)
        )
    }
}