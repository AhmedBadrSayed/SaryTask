import com.google.gson.annotations.SerializedName


data class Other (

	@SerializedName("show_special_order_view") val showSpecialOrderView : Boolean,
	@SerializedName("uncompleted_profile_settings") val uncompletedProfileSettings : UncompletedProfileSettings,
	@SerializedName("business_status") val businessStatus : BusinessStatus
)