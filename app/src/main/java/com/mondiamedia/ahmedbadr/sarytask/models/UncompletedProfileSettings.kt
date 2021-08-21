import com.google.gson.annotations.SerializedName

data class UncompletedProfileSettings (

	@SerializedName("show_tag") val show_tag : Boolean,
	@SerializedName("message") val message : String,
	@SerializedName("image") val image : String,
	@SerializedName("is_completed_profile") val isCompletedProfile : Boolean
)