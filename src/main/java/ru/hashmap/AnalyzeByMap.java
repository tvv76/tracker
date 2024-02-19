package ru.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        Double sum = 0D;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            Double sum = 0D;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            Double pupilAvg = sum / pupil.subjects().size();
            result.add(new Label(pupil.name(), pupilAvg));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> avgBySubjects = new LinkedHashMap();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                Integer temp = 0;
                if (avgBySubjects.containsKey(subject.name())) {
                    temp = avgBySubjects.get(subject.name());
                }
                avgBySubjects.put(subject.name(), temp + subject.score());
            }
        }
        List<Label> result = new ArrayList();
        for (String subject : avgBySubjects.keySet()) {
            Integer score = avgBySubjects.get(subject);
            result.add(new Label(subject, score.doubleValue() / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> scoreByPupils = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            scoreByPupils.add(new Label(pupil.name(), sum));
        }
        scoreByPupils.sort(Comparator.naturalOrder());
        return scoreByPupils.get(scoreByPupils.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> sumScoresBySubjects = new LinkedHashMap();
        List<Label> scoresBySubjects = new ArrayList();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                Integer temp = 0;
                if (sumScoresBySubjects.containsKey(subject.name())) {
                    temp = sumScoresBySubjects.get(subject.name());
                }
                sumScoresBySubjects.put(subject.name(), temp + subject.score());
            }
        }
        for (String subject : sumScoresBySubjects.keySet()) {
            Integer score = sumScoresBySubjects.get(subject);
            scoresBySubjects.add(new Label(subject, score.doubleValue()));
        }

        scoresBySubjects.sort(Comparator.naturalOrder());
        return scoresBySubjects.get(scoresBySubjects.size() - 1);
    }
}
