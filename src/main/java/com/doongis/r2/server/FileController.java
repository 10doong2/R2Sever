package com.doongis.r2.server;

import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("file")
public class FileController {
	@Value("${upload.url}")
	private String uploadUrl;

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@RequestMapping(value = "upload", method = RequestMethod.GET)
	public void upload() {
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public ModelAndView Upload(FileVO fileVO) throws IllegalStateException, IOException {
		CommonsMultipartFile cmf = fileVO.getUpFile();

		long fileSize = cmf.getSize();
		String ofilename = cmf.getOriginalFilename();
		File file = new File(uploadUrl, ofilename);
		String oPath = null;
		try {
			cmf.transferTo(file);
			oPath = makeImage(uploadUrl, ofilename);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("filesize", fileSize);

		return mav;
	}

	public String makeImage(String path, String filename) {
		String originPath = path + "\\" + filename;
		ParameterBlock pb = new ParameterBlock();
		pb.add(originPath);
		RenderedOp op = JAI.create("fileload", pb);

		File file2 = new File(path + "\\" + filename);

		BufferedImage bi = op.getAsBufferedImage();
		try {
			ImageIO.write(bi, "jpg", file2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("굳");

		return originPath;
	}
	

}
