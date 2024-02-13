package com.example.edulab.data

import com.example.edulab.R
import com.example.edulab.model.SubjectDetails

object SubjectList {

    fun loadSubjectList() : List<SubjectDetails> {
        return listOf<SubjectDetails>(
                SubjectDetails(R.string.architecture, R.drawable.architecture,58),
                SubjectDetails(R.string.business, R.drawable.business,121),
                SubjectDetails(R.string.crafts, R.drawable.crafts,78),
                SubjectDetails(R.string.design, R.drawable.design,118),
                SubjectDetails(R.string.culinary, R.drawable.culinary,423),
                SubjectDetails(R.string.drawing, R.drawable.drawing,92),
                SubjectDetails(R.string.fashion, R.drawable.fashion,165),
                SubjectDetails(R.string.film, R.drawable.film,164),
                SubjectDetails(R.string.gaming, R.drawable.gaming,326),
                SubjectDetails(R.string.life, R.drawable.lifestyle,326),
                SubjectDetails(R.string.painting, R.drawable.painting,326),
                SubjectDetails(R.string.photography, R.drawable.photography,326),
              //  SubjectDetails(R.string.painting, R.drawable.painting,326),
                SubjectDetails(R.string.tech, R.drawable.tech,305),
                SubjectDetails(R.string.music, R.drawable.music,212),




            )

    }
}